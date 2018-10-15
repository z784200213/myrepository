package com.serverconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserInforController {
@Autowired
    RestTemplate restTemplate;
    @RequestMapping("/index")
    public String index(){
        String str=  restTemplate.getForObject("http://blogdo/userinfor/index", String.class);
        return "";
    }
}
