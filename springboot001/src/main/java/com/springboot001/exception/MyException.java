package com.springboot001.exception;

/**
 * 自定义异常
 */
public class MyException extends  Exception {
    public  MyException(String msg){
        super(msg);
    }
}
