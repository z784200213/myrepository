package com.annotationtest.Result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResponseBean implements Serializable {
    private String type;

    private int code;

    private String message;

    private Map<String, Object> data = new HashMap<String, Object>();

    /**
     * 自定义返回
     *
     * @param type
     * @param code
     * @param message
     * @return
     */
    public ResponseBean setResponse(String type, int code, String message) {
        this.type = type;
        this.code = code;
        this.message = message;
        return this;
    }

    public ResponseBean setSuccessResponse(String message) {
        this.type = ResponseBeanType.SUCCESS;
        this.code = ResponseBeanCode.SUCCESS;
        this.message = message;
        return this;
    }

    public ResponseBean setErrorResponse(String message) {
        this.type = ResponseBeanType.ERROR;
        this.code = ResponseBeanCode.ERROR;
        this.message = message;
        return this;
    }

    public ResponseBean setExceptionResponse(String message) {
        this.type = ResponseBeanType.ERROR;
        this.code = ResponseBeanCode.ERROR;
        this.message = message;
        return this;
    }

    public ResponseBean setWarnResponse(String message) {
        this.type = ResponseBeanType.WARN;
        this.code = ResponseBeanCode.WARN;
        this.message = message;
        return this;
    }

    public ResponseBean setNoLoginResponse(String message) {
        this.type = ResponseBeanType.ERROR;
        this.code = ResponseBeanCode.NO_LOGIN;
        this.message = message;
        return this;
    }

    public ResponseBean setNoPowerResponse(String message) {
        this.type = ResponseBeanType.ERROR;
        this.code = ResponseBeanCode.NO_POWER;
        this.message = message;
        return this;
    }

    public Object getData(String key) {
        return this.data.get(key);
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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void setData(String key, Object obj) {
        this.data.put(key, obj);
    }

    public void addData(String key, Object obj) {
        this.data.put(key, obj);
    }


}
