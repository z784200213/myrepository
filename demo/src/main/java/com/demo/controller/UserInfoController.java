package com.demo.controller;

import com.demo.entity.Address;
import com.demo.exception.ResultEnum;
import com.demo.exception.TGException;
import com.demo.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/UserInfor")
public class UserInfoController {
    @Autowired
    IUserInforService userInforService;

    @RequestMapping("/Query/id={id}")
    public Address Query(@PathVariable int id) {
        try {
            Object object=null;
            object.toString();
            return userInforService.Query(id);
        }catch (Exception ex){
            String msg=ex.getMessage();
            String msg1= ex.getLocalizedMessage();
            StackTraceElement[] stackTraceElements=  ex.getStackTrace();
           String msg2= ex.toString();
            throw  new TGException(500,msg2);
        }


    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


}
