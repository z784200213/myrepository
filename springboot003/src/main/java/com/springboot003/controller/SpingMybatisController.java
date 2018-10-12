package com.springboot003.controller;

import com.springboot003.entity.User;
import com.springboot003.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mybaits")
@RestController
public class SpingMybatisController {
    @Autowired
    IUserService userService;
    @GetMapping("/index")
    public User index(){
        User user=userService.query(1);
        return user;
    }
}
