package com.springboot005.config;

import com.springboot005.exception.BusinessEnum;
import com.springboot005.exception.BusinessException;
import com.springboot005.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
   @ResponseBody
   @ExceptionHandler(value = Exception.class)
   public ResponseResult handle(Exception ex){
       if(ex instanceof BusinessException){//业务异常的处理
          // BusinessException businessException=(BusinessException)ex;
            //BusinessEnum businessEnum=  businessException.getBusinessEnum();
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass().getName());
            return  ResponseResult.fail(ex.getMessage());
           // return businessEnum.getValue()+"异常";
       }
       return ResponseResult.fail(ex.getMessage());
   }
}
