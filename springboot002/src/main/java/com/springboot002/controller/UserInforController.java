package com.springboot002.controller;

import com.springboot002.entity.UserInfor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userinfor")
public class UserInforController {
    @RequestMapping(value = "/userinfor",method = RequestMethod.POST)
    public UserInfor userInfor(@RequestBody UserInfor userInfor){
        return  userInfor;

    }
}
