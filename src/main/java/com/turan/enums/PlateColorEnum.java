package com.turan.enums;

import lombok.Getter;

@Getter
public enum PlateColorEnum
{
    NONE(0,"无"),
    YELLOW(2,"黄色")
    ;

    private int code;
    private String desc;

    PlateColorEnum(int code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }
}
