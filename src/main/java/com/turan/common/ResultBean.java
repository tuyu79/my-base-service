package com.turan.common;


import java.io.Serializable;

/**
 * 响应数据基础结构
 * @param <T>
 */
public class ResultBean<T> implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private T data;

    private ResultBean(T data)
    {
        this.data = data;
    }

    private ResultBean(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    private ResultBean(int code, String msg, T data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResultBean(IRespCode respCode)
    {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    private ResultBean(IRespCode respCode, T data)
    {
        this.data = data;
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    private ResultBean(IRespCode respCode, String msg)
    {
        this.code = respCode.getCode();
        this.msg = msg;
    }

    public static ResultBean<Void> of(int code, String msg)
    {
        return new ResultBean<>(code, msg);
    }

    public static <T> ResultBean<T> of(int code, String msg, T data)
    {
        return new ResultBean<>(code, msg, data);
    }

    public static <T> ResultBean<T> of(T data)
    {
        return new ResultBean<>(data);
    }

    public static <T> ResultBean<T> of(IRespCode respCode)
    {
        return new ResultBean<>(respCode);
    }

    public static <T> ResultBean<T> of(IRespCode respCode, T data)
    {
        return new ResultBean<>(respCode, data);
    }

    public static <T> ResultBean<T> of(IRespCode respCode, String msg)
    {
        return new ResultBean<>(respCode, msg);
    }

    public Integer getCode()
    {
        return code;
    }

    public String getMsg()
    {
        return msg;
    }

    public T getData()
    {
        return data;
    }
}
