package com.zqh.schoolproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zqh.schoolproject.dao")
@SpringBootApplication
public class SchoolprojectApplication {

    public static void main(String[] args) {

        SpringApplication.run(SchoolprojectApplication.class, args);
    }
}
