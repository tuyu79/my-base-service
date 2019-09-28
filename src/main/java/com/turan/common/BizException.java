package com.turan.common;

/**
 * 业务异常
 */
public class BizException extends RuntimeException
{
    private Integer code;
    private String msg;

    public BizException(RespCode respCode)
    {
        super();
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public BizException(RespCode respCode, String msg)
    {
        super();
        this.code = respCode.getCode();
        this.msg = msg;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}
