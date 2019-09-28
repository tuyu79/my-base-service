package com.turan.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Device
{
    @NotBlank
    private String simCardNo;
    @NotNull
    private Integer devType;
    @NotBlank
    private String devId;
    @NotNull
    private Integer channelCount;
    @NotBlank
    private String channelEnabled;
    @NotNull
    private Integer protocolType;
}
