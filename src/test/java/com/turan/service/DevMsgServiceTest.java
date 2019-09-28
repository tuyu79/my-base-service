package com.turan.service;

import com.alibaba.fastjson.JSON;
import com.turan.bo.BaseDownMsg;
import com.turan.common.BaseRespCode;
import com.turan.common.IRespCode;
import com.turan.common.RespCode;
import com.turan.enums.CommonResultEnum;
import com.turan.enums.RegisterResult;
import com.turan.example.mq.AuthMsg;
import com.turan.example.mq.CommonResponse;
import com.turan.example.mq.RegisterMsg;
import com.turan.example.mq.RegisterResponse;
import com.turan.example.protocol.message.dev.D_0003;
import com.turan.example.protocol.message.dev.D_0100;
import com.turan.example.protocol.message.dev.D_0102;
import com.turan.mq.bo.MQ808Msg;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DevMsgServiceTest
{

    @Spy
    @InjectMocks
    private DevMsgService devMsgService;
    @Mock
    private DevRegisterService devRegisterService;
    @Mock
    private DevUnregisterService devUnregisterService;
    @Mock
    private DevAuthService devAuthService;
    @Mock
    private MessageChannel vehicleResponseOutput;
    @Mock
    private MessageChannel output2;

    private MQ808Msg mq808Msg;

    @Before
    public void init() throws Exception
    {
        mq808Msg = new MQ808Msg();
        mq808Msg.setChannelId(123456);
        mq808Msg.setMobile("13452202456");
        mq808Msg.setMsgUid(1);
    }

    @Test
    public void whenRegisterMsgThenSuccess() throws UnsupportedEncodingException
    {
        RegisterMsg registerMsg = new RegisterMsg();
        registerMsg.setProvinceId(1);
        registerMsg.setCityId(1);
        registerMsg.setManufacturer("123");
        registerMsg.setTerminalType("D5X");
        registerMsg.setTerminalId("abc");
        registerMsg.setPlateColor(0);
        registerMsg.setVehicleMark("测A0002");

        mq808Msg.setMsgBody(JSON.toJSONString(registerMsg));
        mq808Msg.setMsgType("REGISTER");
        mq808Msg.setMsgId(D_0100.MSG_ID);

        doReturn(org.apache.commons.lang3.tuple.Pair.of(RegisterResult.SUCCESS, "123")).when(devRegisterService).onRegister(anyInt(), anyString(), anyString());
        doReturn(1).when(devMsgService).getMsgUid();

        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setDevMsgUid(mq808Msg.getMsgUid());
        registerResponse.setResult(RegisterResult.SUCCESS.getCode());
        registerResponse.setAuthCode("123");

        MQ808Msg response = new MQ808Msg(mq808Msg);
        response.setMsgUid(1);
        response.setMsgBody(JSON.toJSONString(registerResponse));
        response.setMsgType("REGISTER_RESPONSE");

        devMsgService.handle(mq808Msg);

        verify(devMsgService, times(1)).sendMsgToVehicle(response);
    }

    @Test
    public void whenAuthMsgThenSuccess()
    {
        AuthMsg authMsg = new AuthMsg();
        authMsg.setAuthCode("123456");

        mq808Msg.setMsgBody(JSON.toJSONString(authMsg));
        mq808Msg.setMsgType("AUTH");
        mq808Msg.setMsgId(D_0102.MSG_ID);

        doReturn(CommonResultEnum.SUCCESS).when(devAuthService).onAuth(anyInt(),anyString(), anyString());
        doReturn(1).when(devMsgService).getMsgUid();

        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setDevMsgUid(mq808Msg.getMsgUid());
        commonResponse.setDevMsgId(mq808Msg.getMsgId());
        commonResponse.setResult(CommonResultEnum.SUCCESS.getCode());

        MQ808Msg response = new MQ808Msg(mq808Msg);
        response.setMsgType("COMMON_RESPONSE");
        response.setMsgUid(1);
        response.setMsgBody(JSON.toJSONString(commonResponse));

        devMsgService.handle(mq808Msg);

        verify(devMsgService, times(1)).sendMsgToVehicle(response);
    }

    @Test
    public void whenUnregisterMsgThenSuccess()
    {
        mq808Msg.setMsgBody(JSON.toJSONString(new D_0003()));
        mq808Msg.setMsgType("UNREGISTER");
        mq808Msg.setMsgId(D_0003.MSG_ID);

        doReturn(1).when(devMsgService).getMsgUid();

        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setDevMsgUid(mq808Msg.getMsgUid());
        commonResponse.setDevMsgId(mq808Msg.getMsgId());
        commonResponse.setResult(CommonResultEnum.SUCCESS.getCode());

        MQ808Msg response = new MQ808Msg(mq808Msg);
        response.setMsgType("COMMON_RESPONSE");
        response.setMsgUid(1);
        response.setMsgBody(JSON.toJSONString(commonResponse));

        devMsgService.handle(mq808Msg);

        verify(devMsgService, times(1)).sendMsgToVehicle(response);
    }


    @Test
    public void whenOtherMsgAndNotOnlineThenDoNothing()
    {
        doReturn(false).when(devAuthService).isOnline(123456);

        mq808Msg.setMsgType("GPS");

        devMsgService.handle(mq808Msg);

        verify(devMsgService, times(0)).sendVehicleMsgToOtherService(mq808Msg);
    }

    @Test
    public void whenOtherMsgAndOnlineThenSuccess()
    {
        doReturn(true).when(devAuthService).isOnline(123456);

        mq808Msg.setMsgType("GPS");

        devMsgService.handle(mq808Msg);

        verify(devMsgService, times(1)).sendVehicleMsgToOtherService(mq808Msg);
    }

    @Test
    public void whenSendMsgToVehicleAndVehicleNotOnlineThenFail()
    {
        BaseDownMsg downMsg = new BaseDownMsg();
        downMsg.setVehicleNo(123L);
        downMsg.setMsgType("UPLOAD_ATTACHMENT");

        doReturn(Optional.empty()).when(devAuthService).getOnlineChannelIdByVehicleNo(anyLong());

        IRespCode iRespCode = devMsgService.sendBaseDownMsg(downMsg);

        assertThat(iRespCode,is(BaseRespCode.VEHICLE_NOT_ONLINE));
    }

    @Test
    public void whenSendMsgToVehicleAndVehicleIsOnlineThenSuccess()
    {
        BaseDownMsg downMsg = new BaseDownMsg();
        downMsg.setVehicleNo(123L);
        downMsg.setMsgType("UPLOAD_ATTACHMENT");

        doReturn(Optional.of(456)).when(devAuthService).getOnlineChannelIdByVehicleNo(anyLong());

        IRespCode iRespCode = devMsgService.sendBaseDownMsg(downMsg);

        assertThat(iRespCode,is(RespCode.SUCCESS));
        verify(vehicleResponseOutput,times(1)).send(any(Message.class));
    }

}