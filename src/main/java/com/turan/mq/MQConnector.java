package com.turan.mq;

import com.turan.mq.bo.MQ808Msg;
import com.turan.mq.bo.MQVehicleDisConnectedMsg;
import com.turan.service.DevMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class MQConnector
{
    @Autowired
    private DevMsgService devMsgService;

    @StreamListener("input-device")
    public void input1(MQ808Msg mq808Msg)
    {
        devMsgService.handle(mq808Msg);
    }
    @StreamListener("input-gateway")
    public void input2(MQVehicleDisConnectedMsg msg)
    {
        devMsgService.handleDisconnected(msg);
    }
}
