package com.springboot003.controller;

import com.springboot003.entity.UserInfor;
import com.springboot003.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OderController {
    @Autowired
    UserInfor userInfor;
    @Resource(name="orderservice")
    IOrderService orderService;
    @RequestMapping("/index")
    public UserInfor index(){
        String str=   orderService.getStr();
        return  userInfor;
    }
}
