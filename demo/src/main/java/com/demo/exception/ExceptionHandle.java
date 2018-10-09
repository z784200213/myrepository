package com.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Msg handle(Exception e){
        if(e instanceof TGException){
            TGException tgException=(TGException) e;
            return ResultUtil.error(tgException.getCode(),tgException.toString());
           // return ResultUtil.error(tgException.getCode(),tgException.getMessage());
        }else {
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
