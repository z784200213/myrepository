package com.springboot005;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@MapperScan("com.springboot005.dao")
@SpringBootApplication
public class Springboot005Application {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(Springboot005Application.class, args);
        String str=   ResourceUtils.getURL("classpath:").getPath();
        System.out.println(str);
    }
}
