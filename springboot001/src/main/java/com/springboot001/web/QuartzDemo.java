package com.springboot001.web;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Future;

@Component
//@EnableScheduling
public class QuartzDemo {
    @Scheduled(fixedRate = 5000)
    public void  work(){
        System.out.println("work开始执行"+new Date());

    }
}
