package com.turan.enums;

import lombok.Getter;

@Getter
public enum IsRegisterEnum
{
    NO(0,"未注册"),
    YES(1,"已注册")
    ;

    private int code;
    private String desc;

    IsRegisterEnum(int code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }
}
