package com.turan.common;

/**
 * 返回码 :
 *  = 0 -- 成功
 *  > 0 ---> 已知错误
 *  -1 ---> 未知错误
 */
public enum RespCode implements IRespCode
{
    SUCCESS(0,"成功"),
    INVALID_PARAMS(1,"参数非法"),
    SYS_ERROR(-1,"系统错误")
    ;

    private int code;
    private String msg;

    RespCode(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode()
    {
        return code;
    }

    @Override
    public String getMsg()
    {
        return msg;
    }
}
