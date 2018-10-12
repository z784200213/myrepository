package com.springboot003.controller;

import com.springboot003.entity.UserInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfor")
public class UserInforController {

    final UserInfor userInfor;

    @Autowired
    public UserInforController(UserInfor _userinfor) {
        userInfor = _userinfor;
    }
    @RequestMapping("/index")
    public UserInfor index() {
        return userInfor;
    }
}
