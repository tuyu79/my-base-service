package com.turan.common;

public enum BaseRespCode implements IRespCode
{
    VEHICLE_NOT_EXIST(2,"车辆不存在"),
    VEHICLE_NOT_ONLINE(3,"车辆不在线"),
    ;

    private int code;
    private String msg;

    BaseRespCode(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode()
    {
        return 0;
    }

    @Override
    public String getMsg()
    {
        return null;
    }
}
