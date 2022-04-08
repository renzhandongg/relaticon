package com.relation.pojo.result;

public class CodMsg {
    private Integer code;
    private String msg;

    public static final CodMsg REQUEST_SUCCESS = new CodMsg(200,"请求成功");

    public static final CodMsg OPERATION_SUCCESS = new CodMsg(200,"操作成功");

    public static final CodMsg REQUEST_ERROR = new CodMsg(500,"请求异常");

    public static final CodMsg OPERATION_ERROR = new CodMsg(500,"操作异常");

    public static final CodMsg SERVER_ERROR = new CodMsg(500,"操作异常");

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

    private CodMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
