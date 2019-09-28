package com.turan.enums;

import lombok.Getter;

@Getter
public enum RegisterResult
{
    SUCCESS(0,"成功"),
    VEHICLE_HAS_BEEN_REGISTERED(1,"车辆已被注册") ,
    VEHICLE_NOT_EXIST(2,"数据库中无该车辆"),
    DEV_HAS_BEEN_REGISTERED(3,"终端已被注册"),
    DEV_NOT_EXIST(4,"数据库中无该终端")
    ;

    private int code;
    private String desc;

    RegisterResult(int code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }
}
