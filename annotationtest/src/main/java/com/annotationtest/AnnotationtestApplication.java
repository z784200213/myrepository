package com.annotationtest;

import com.annotationtest.entity.UserInfor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.annotationtest.dao")
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching

public class AnnotationtestApplication {


    public static void main(String[] args) {

        SpringApplication.run(AnnotationtestApplication.class, args);
    }
}
