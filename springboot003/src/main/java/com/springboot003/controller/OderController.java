package com.springboot003.controller;

import com.springboot003.entity.UserInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OderController {
    @Autowired
    UserInfor userInfor;
    @RequestMapping("/index")
    public UserInfor index(){
        return  userInfor;
    }
}
