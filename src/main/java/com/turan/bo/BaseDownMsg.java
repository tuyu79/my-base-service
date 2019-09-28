package com.turan.bo;

import lombok.Data;

@Data
public class BaseDownMsg
{
    private Long vehicleNo;
    private String msgType;
    private String msgBody;
}
