package com.annotationtest.common;

import com.annotationtest.Result.ResponseBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WebAspectAnno {
    /**
     * 切入点
     * 用注解
     */
    @Pointcut("@annotation(com.annotationtest.common.WebDesc)")
    public void executeAnnotation() {
    }

    @Before("executeAnnotation()")
    public void beforeAdviceAnnotation() {
        System.out.println("- - - - - 前置通知 annotation - - - - -");
    }

    @Around("@annotation(webDesc)")
    public Object aroundAnnotation(ProceedingJoinPoint proceedingJoinPoint, WebDesc webDesc) {
        ResponseBean bean = new ResponseBean();
        System.out.println("- - - - - 环绕通知 annotation - - - -");
        //获取注解里的值
        System.out.println("注解的值:" + webDesc.describe());
        try {//obj之前可以写目标方法执行前的逻辑
            bean = (ResponseBean) proceedingJoinPoint.proceed();//调用执行目标方法
            bean.setSuccessResponse("成功");
            System.out.println("- - - - - 环绕通知 annotation end - - - -");
            return bean;
        } catch (Throwable throwable) {

            bean.setErrorResponse(throwable.toString());
            return bean;
            //throwable.printStackTrace();
        }
        //return null;
    }
}