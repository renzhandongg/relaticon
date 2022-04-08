package com.relation.pojo.result;

public class ResultUtil {
    private Integer code;
    private String msg;
    private Object result;

    public static ResultUtil success(String msg){
        return new ResultUtil(200,msg);
    }

    public static ResultUtil success(String msg,Object result){
        return new ResultUtil(200,msg,result);
    }

    public static ResultUtil success(CodMsg codMsg){
        return new ResultUtil(codMsg);
    }

    public static ResultUtil success(CodMsg codMsg,Object result){
        return new ResultUtil(codMsg,result);
    }

    public static ResultUtil error(String msg){
        return new ResultUtil(500,msg);
    }

    public static ResultUtil error(String msg,Object result){
        return new ResultUtil(500,msg,result);
    }

    public static ResultUtil error(CodMsg codMsg){
        return new ResultUtil(codMsg);
    }

    public static ResultUtil error(CodMsg codMsg,Object result){
        return new ResultUtil(codMsg,result);
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    private ResultUtil(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResultUtil(Integer code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    private ResultUtil(CodMsg codMsg) {
        this.code = codMsg.getCode();
        this.msg = codMsg.getMsg();
    }

    private ResultUtil(CodMsg codMsg,Object result) {
        this.code = codMsg.getCode();
        this.msg = codMsg.getMsg();
        this.result = result;
    }

    private ResultUtil() {
    }
}
