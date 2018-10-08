package com.reptile.result;

public class ResponseResult<T> {
    public   Code code;
    public   String message;
    public   T dataList;
    public  ResponseResult(){
    }
    public ResponseResult success(T data){
        this.dataList=data;
        this.code=Code.Success;
        return  this;
    }
    public  ResponseResult error(){
        this.code=Code.Error;
        return  this;
    }
    public ResponseResult fail(T data){
        this.code=Code.Fail;
        this.dataList=data;
        return this;
    }
    public ResponseResult exception(T data){
        this.code=Code.Exception;
        this.dataList=data;
        return  this;
    }
    public ResponseResult noAuth(){
        this.code=Code.NoAuth;
        this.message=ResponseMessage.AUTH;
        return  this;
    }
}
