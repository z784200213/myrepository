package com.springboot005.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
@Aspect
public class TrancationAspect {
    /**
     * 切入点
     * 用注解
     */
    @Pointcut("@annotation(com.springboot005.aspect.UseTrancation)")
    public void executeAnnotation() {
    }

    @Before("executeAnnotation()")
    public void beforeAdviceAnnotation() {
        System.out.println("- - - - - 前置通知 annotation - - - - -");
    }

    @Around("@annotation(useTrancation)")
    public Object aroundAnnotation(ProceedingJoinPoint proceedingJoinPoint, UseTrancation useTrancation) {
        System.out.println("- - - - - 环绕通知 annotation - - - -");
        try {//obj之前可以写目标方法执行前的逻辑
            Object bean = proceedingJoinPoint.proceed();//调用执行目标方法
            System.out.println("- - - - - 环绕通知 annotation end - - - -");
            return bean;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            TransactionStatus transactionStatus = TransactionAspectSupport.currentTransactionStatus();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return null;
    }
}
