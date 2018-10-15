package com.annotationtest.common;

import com.annotationtest.Result.DataResult;
import org.apache.ibatis.transaction.managed.ManagedTransaction;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@Aspect
public class TestAspect {
    @Autowired
    DataSource dataSource;

    /**
     * 切入点
     * 用注解
     */
    @Pointcut("@annotation(com.annotationtest.common.TestAnno)")
    public void executeAnnotation() {
    }

    @Before("executeAnnotation()")
    public void beforeAdviceAnnotation() {
        System.out.println("- - - - - 前置通知 annotation - - - - -");
    }

    @Around("@annotation(webDesc)")

    public Object aroundAnnotation(ProceedingJoinPoint proceedingJoinPoint, TestAnno webDesc) throws SQLException {
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
         /*   DataResult<String> bean=new DataResult<String>("错误");
            bean.setErrorResponse(throwable.toString());
            return  bean;*/
            throw new RuntimeException();

        } finally {
          /*      DataResult<String> bean=new DataResult<String>("错误");
        bean.setErrorResponse("错误");
        return  bean;*/
        }


    }

    /**
     * 后置通知
     *
     * @param joinPoint
     */
    @After("executeAnnotation()")
    public void after(JoinPoint joinPoint) {
        String s = "123";
    }
}
