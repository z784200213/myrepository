package com.springboot001.exception;

/**
 * 自定义全局异常
 */
public class GlobException extends  Exception {
    public  GlobException(String msg){
        super(msg);
    }
}
