package com.turan.enums;

import lombok.Getter;

@Getter
public enum CommonResultEnum
{
    SUCCESS(0,"成功"),
    FAIL(1,"失败")
    ;

    private int code;
    private String desc;

    CommonResultEnum(int code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }
}
