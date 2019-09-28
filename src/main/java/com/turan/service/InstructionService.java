package com.turan.service;

import com.google.common.collect.ImmutableMap;
import com.turan.common.BaseRespCode;
import com.turan.common.IRespCode;
import com.turan.common.RespCode;
import com.turan.feign.api.baseservice.bo.InstructionRequest;
import com.turan.mq.bo.MQ808Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class InstructionService
{
    @Autowired
    private MessageChannel baseServiceDownMsg;
    @Autowired
    private DevAuthService devAuthService;

    public IRespCode toGateway(InstructionRequest instructionRequest)
    {
        Optional<Integer> channelId = devAuthService.getOnlineChannelIdByVehicleNo(instructionRequest.getVehicleNo());
        if(!channelId.isPresent())
        {
            log.info("[vehicle not online],vehicleNo: [{}]",instructionRequest.getVehicleNo());
            return BaseRespCode.VEHICLE_NOT_ONLINE;
        }

        MQ808Msg mq808Msg = new MQ808Msg();
        mq808Msg.setMsgBody(instructionRequest.getData());
        mq808Msg.setMsgType(instructionRequest.getMsgType());
        mq808Msg.setMobile(devAuthService.getMobileByVehicleNo(instructionRequest.getVehicleNo()));
        mq808Msg.setChannelId(channelId.get());

        Message<MQ808Msg> message = MessageBuilder.createMessage(mq808Msg, new MessageHeaders(ImmutableMap.of()));
        baseServiceDownMsg.send(message);

        log.info("[send mq],message: [{}]",mq808Msg);
        return RespCode.SUCCESS;
    }
}
