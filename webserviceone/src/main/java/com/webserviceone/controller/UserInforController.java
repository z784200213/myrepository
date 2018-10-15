package com.webserviceone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfor")
public class UserInforController {
    @RequestMapping("/index")
    public  String index()
    {
        return "调用成功";
    }
}
