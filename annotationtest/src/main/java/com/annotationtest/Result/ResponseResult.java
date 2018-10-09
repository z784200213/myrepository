package com.annotationtest.Result;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseResult implements Serializable {
    private String type ;

    private int code ;

    private String message ;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private  Object data;

    /**
     * 自定义返回
     * @param type
     * @param code
     * @param message
     * @return
     */
    public ResponseResult setResponse(String type, int code, String message){
        this.type = type;
        this.code = code;
        this.message = message;
        return this;
    }

    public ResponseResult setSuccessResponse(String message){
        this.type = ResponseBeanType.SUCCESS ;
        this.code = ResponseBeanCode.SUCCESS ;
        this.message = message ;
        return this;
    }

    public ResponseResult setErrorResponse(String message){
        this.type = ResponseBeanType.ERROR ;
        this.code = ResponseBeanCode.ERROR ;
        this.message = message ;
        return this;
    }

    public ResponseResult setExceptionResponse(String message){
        this.type = ResponseBeanType.ERROR ;
        this.code = ResponseBeanCode.ERROR ;
        this.message = message ;
        return this;
    }

    public ResponseResult setWarnResponse(String message) {
        this.type = ResponseBeanType.WARN ;
        this.code = ResponseBeanCode.WARN ;
        this.message = message ;
        return this;
    }
    public ResponseResult setNoLoginResponse(String message){
        this.type = ResponseBeanType.ERROR ;
        this.code = ResponseBeanCode.NO_LOGIN ;
        this.message = message ;
        return this;
    }
    public ResponseResult setNoPowerResponse(String message){
        this.type = ResponseBeanType.ERROR ;
        this.code = ResponseBeanCode.NO_POWER ;
        this.message = message ;
        return this;
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
