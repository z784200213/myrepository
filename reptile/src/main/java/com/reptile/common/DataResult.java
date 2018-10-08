package com.reptile.common;

import java.io.Serializable;


public  class DataResult<T> implements Serializable {
    private String type ;
    private int code ;
    private String message ;
    private  T data;





    /**
     * 自定义返回
     * @param type
     * @param code
     * @param message
     * @return
     */
    public DataResult setResponse(String type, int code, String message){
        this.type = type;
        this.code = code;
        this.message = message;
        return this;
    }

    public DataResult setSuccessResponse(String message){
        this.type = ResponseBeanType.SUCCESS ;
        this.code = ResponseBeanCode.SUCCESS ;
        this.message = message ;
        return this;
    }

    public DataResult setErrorResponse(String message){
        this.type = ResponseBeanType.ERROR ;
        this.code = ResponseBeanCode.ERROR ;
        this.message = message ;
        return this;
    }

    public DataResult setExceptionResponse(String message){
        this.type = ResponseBeanType.ERROR ;
        this.code = ResponseBeanCode.ERROR ;
        this.message = message ;
        return this;
    }

    public DataResult setWarnResponse(String message) {
        this.type = ResponseBeanType.WARN ;
        this.code = ResponseBeanCode.WARN ;
        this.message = message ;
        return this;
    }
    public DataResult setNoLoginResponse(String message){
        this.type = ResponseBeanType.ERROR ;
        this.code = ResponseBeanCode.NO_LOGIN ;
        this.message = message ;
        return this;
    }
    public DataResult setNoPowerResponse(String message){
        this.type = ResponseBeanType.ERROR ;
        this.code = ResponseBeanCode.NO_POWER ;
        this.message = message ;
        return this;
    }
public  DataResult SetResponse(T data){
    this.type = ResponseBeanType.ERROR ;
    this.code = ResponseBeanCode.NO_POWER ;
   this.data=data;
    return this;
}
    public  DataResult(T data){
    this.type = ResponseBeanType.SUCCESS ;
    this.code = ResponseBeanCode.SUCCESS ;
    this.data=data;

    }
    public  DataResult(){}


    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
