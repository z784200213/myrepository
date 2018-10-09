package com.demo.exception;

public class Msg {
    public Msg(int code,String message){
        this.Code=code;
        this.Message=message;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    private   int Code;
    private String Message;


}
