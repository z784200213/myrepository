package com.reptile.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTrancation {

    /**
     * 切入点
     * 用注解
     */
    @Pointcut("@annotation(com.reptile.aspect.TrancationAno)")
    public void executeAnnotation(){
    }

    @Before("executeAnnotation()")
    public void beforeAdviceAnnotation(){
        System.out.println("- - - - - 前置通知 annotation - - - - -");
    }

    @Around("@annotation(annoTest)")
    public Object aroundAnnotation(ProceedingJoinPoint proceedingJoinPoint, TrancationAno annoTest) throws Throwable  {
            Object obj=     proceedingJoinPoint.proceed();
            return obj;
    }
}
