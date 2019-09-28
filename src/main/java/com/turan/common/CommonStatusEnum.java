package com.turan.common;

public enum CommonStatusEnum
{
    DISABLED(0,"禁用"),
    ENABLED(1,"启用")
    ;

    private int code;
    private String desc;

    CommonStatusEnum(int code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    public int getCode()
    {
        return code;
    }

    public String getDesc()
    {
        return desc;
    }
}
