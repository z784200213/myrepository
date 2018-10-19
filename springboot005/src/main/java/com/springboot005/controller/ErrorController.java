package com.springboot005.controller;

import com.springboot005.exception.BusinessEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {
    @GetMapping("/auth")
    public String  auth(){
        BusinessEnum businessEnum=  BusinessEnum.Order;
        String str= businessEnum.getValue();
        return "无权限";
    }
}
