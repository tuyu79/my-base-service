package com.turan.mq.bo;

import lombok.Data;

@Data
public class MQ808Msg
{
    private Integer channelId;
    private Long vehicleNo;
    private String msgType;
    private Integer msgId;
    private String mobile;
    private Integer msgUid;
    private String msgBody;

    public MQ808Msg()
    {
    }

    public MQ808Msg(MQ808Msg mq808Msg)
    {
        this.channelId = mq808Msg.getChannelId();
        this.msgType = mq808Msg.getMsgType();
        this.mobile = mq808Msg.getMobile();
        this.msgUid = mq808Msg.getMsgUid();
        this.msgBody = mq808Msg.getMsgBody();
    }
}
