package com.annotationtest.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.SQLException;
@Aspect
@Component
public class AnnoTestaspect {

    /**
     * 切入点
     * 用注解
     */
    @Pointcut("@annotation(com.annotationtest.common.AnnoTest)")
    public void executeAnnotation(){
    }

    @Before("executeAnnotation()")
    public void beforeAdviceAnnotation(){
        System.out.println("- - - - - 前置通知 annotation - - - - -");
    }

    @Around("@annotation(annoTest)")
    public Object aroundAnnotation(ProceedingJoinPoint proceedingJoinPoint, AnnoTest annoTest) throws Throwable  {
            Object obj=     proceedingJoinPoint.proceed();
            return obj;
    }
}
