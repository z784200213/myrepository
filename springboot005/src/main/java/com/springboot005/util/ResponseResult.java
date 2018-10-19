package com.springboot005.util;

public class ResponseResult<T>  {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public SuccessType getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(SuccessType isSuccess) {
        this.isSuccess = isSuccess;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private int code;
    private SuccessType isSuccess;
    private T data;
    private String message;
    public ResponseResult(){}

    private ResponseResult(int code,SuccessType isSuccess,String message,T data)
    {
        this.code=code;
        this.isSuccess=isSuccess;
        this.message=message;
        this.data=data;
    }
    public static ResponseResult fail(String message)
    {
        ResponseResult responseResult=new ResponseResult(-1,SuccessType.Fail,message,null);
        return  responseResult;
    }
    public static ResponseResult success(Object data){
        ResponseResult responseResult=new ResponseResult(1,SuccessType.Success,null,data);
        return responseResult;
    }
}
enum SuccessType{
    Success,
    Fail
}