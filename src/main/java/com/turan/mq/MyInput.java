package com.turan.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MyInput
{
    @Input("input-device")
    SubscribableChannel input1();

    @Input("input-gateway")
    SubscribableChannel input2();
}
