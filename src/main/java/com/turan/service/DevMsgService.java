package com.turan.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
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
import com.turan.example.protocol.util.MessageUtil;
import com.turan.mq.bo.MQ808Msg;
import com.turan.mq.bo.MQVehicleDisConnectedMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class DevMsgService
{
    // todo turan 分布式获取
    private static final AtomicInteger MSG_UID = new AtomicInteger(0);

    @Resource
    private MessageChannel baseServiceDownMsg;
    @Resource
    private MessageChannel output2;
    @Autowired
    private DevRegisterService devRegisterService;
    @Autowired
    private DevAuthService devAuthService;
    @Autowired
    private DevUnregisterService devUnRegisterService;

    public void handle(MQ808Msg mq808Msg)
    {
        Objects.requireNonNull(mq808Msg.getMsgType());

        log.info("received msg,msg : [{}]",mq808Msg);

        if ("REGISTER".equals(mq808Msg.getMsgType()))
        {
            String msgBody = mq808Msg.getMsgBody();
            RegisterMsg registerMsg = JSON.parseObject(msgBody, RegisterMsg.class);
            // 传入的是gbk字符串
            registerMsg.setVehicleMark(MessageUtil.getUTF8StringFromGBKString(registerMsg.getVehicleMark()));

            log.info("register vehicle mark: [{}]",registerMsg.getVehicleMark());
            Pair<RegisterResult, String> registerResult = devRegisterService.onRegister(registerMsg.getPlateColor(),
                    registerMsg.getVehicleMark(), registerMsg.getTerminalId());

            RegisterResponse registerResponse = new RegisterResponse();
            registerResponse.setDevMsgUid(mq808Msg.getMsgUid());
            registerResponse.setResult(registerResult.getLeft().getCode());
            registerResponse.setAuthCode(registerResult.getRight());

            MQ808Msg response = new MQ808Msg(mq808Msg);
            response.setMsgType("REGISTER_RESPONSE");
            response.setMsgUid(getMsgUid());
            response.setMsgBody(JSON.toJSONString(registerResponse));

            log.info("send response, msg : [{}]",response);
            sendMsgToVehicle(response);

        } else if ("AUTH".equals(mq808Msg.getMsgType()))
        {
            String msgBody = mq808Msg.getMsgBody();
            AuthMsg authMsg = JSON.parseObject(msgBody, AuthMsg.class);

            CommonResultEnum commonResultEnum = devAuthService.onAuth(mq808Msg.getChannelId(), mq808Msg.getMobile(), authMsg.getAuthCode());

            MQ808Msg response = getCommonResp(mq808Msg, commonResultEnum);

            log.info("send response, msg : [{}]",response);
            sendMsgToVehicle(response);
        } else if("UNREGISTER".equals(mq808Msg.getMsgType()))
        {
            Long vehicleNo = devAuthService.getVehicleNoByChannelId(mq808Msg.getChannelId());

            if(vehicleNo == null)
            {
                MQ808Msg response = getCommonResp(mq808Msg, CommonResultEnum.FAIL);

                log.info("vehicle is not online,send response, msg : [{}]",response);
                sendMsgToVehicle(response);
                return;
            }

            devUnRegisterService.onUnRegister(mq808Msg.getMobile(),
                    vehicleNo);

            MQ808Msg response = getCommonResp(mq808Msg, CommonResultEnum.SUCCESS);

            log.info("send response, msg : [{}]",response);
            sendMsgToVehicle(response);
        }
        else
        {
            // 判断是否在线
            if (!devAuthService.isOnline(mq808Msg.getChannelId()))
            {
                log.info("vehicle not online, channelId : [{}]", mq808Msg.getChannelId());
                return;
            }

            log.info("send msg to other service, msg : [{}]",mq808Msg);
            mq808Msg.setVehicleNo(devAuthService.getVehicleNoByChannelId(mq808Msg.getChannelId()));
            sendVehicleMsgToOtherService(mq808Msg);
        }
    }

    private MQ808Msg getCommonResp(MQ808Msg mq808Msg, CommonResultEnum commonResultEnum)
    {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setDevMsgUid(mq808Msg.getMsgUid());
        commonResponse.setDevMsgId(mq808Msg.getMsgId());
        commonResponse.setResult(commonResultEnum.getCode());

        MQ808Msg response = new MQ808Msg(mq808Msg);
        response.setMsgUid(getMsgUid());
        response.setMsgType("COMMON_RESPONSE");
        response.setMsgBody(JSON.toJSONString(commonResponse));
        return response;
    }

    public void sendVehicleMsgToOtherService(MQ808Msg mq808Msg)
    {
        Message message = MessageBuilder.createMessage(mq808Msg, new MessageHeaders(ImmutableMap.of()));
        output2.send(message);
    }

    public void sendMsgToVehicle(MQ808Msg mq808Msg)
    {
        Message message = MessageBuilder.createMessage(mq808Msg, new MessageHeaders(ImmutableMap.of()));
        baseServiceDownMsg.send(message);
    }

    int getMsgUid()
    {
        return MSG_UID.getAndIncrement();
    }

    public void handleDisconnected(MQVehicleDisConnectedMsg msg)
    {
        devAuthService.disConnected(msg.getChannelId());
    }

    public IRespCode sendBaseDownMsg(BaseDownMsg downMsg)
    {
        Optional<Integer> channelId = devAuthService.getOnlineChannelIdByVehicleNo(downMsg.getVehicleNo());

        if (!channelId.isPresent())
        {
            return BaseRespCode.VEHICLE_NOT_ONLINE;
        }

        MQ808Msg mq808Msg = new MQ808Msg();
        mq808Msg.setChannelId(channelId.get());
        mq808Msg.setMsgType(downMsg.getMsgType());
        mq808Msg.setMsgBody(downMsg.getMsgBody());
        sendMsgToVehicle(mq808Msg);

        return RespCode.SUCCESS;
    }
}
