package com.han.exception;

public class MyException extends Exception{
    private Integer code = 400;
    private String msg = "自定义异常";

    public MyException() {
        super("自定义异常!");
    }

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MyException(Integer code) {
        super("自定义异常!");
        this.code = code;
    }

    public MyException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

