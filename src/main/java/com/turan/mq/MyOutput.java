package com.turan.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Description
 * @Date 2019/6/22 11:47
 * @Created by turan
 */
public interface MyOutput
{
    @Output("baseServiceDownMsg")
    MessageChannel baseServiceDownMsg();

    @Output("output2")
    MessageChannel output2();

    @Output("output3")
    MessageChannel output3();

    @Output("output4")
    MessageChannel output4();
}
