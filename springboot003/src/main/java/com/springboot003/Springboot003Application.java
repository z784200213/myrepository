package com.springboot003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.springboot003.dao")
@SpringBootApplication
public class Springboot003Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot003Application.class, args);
    }
}
