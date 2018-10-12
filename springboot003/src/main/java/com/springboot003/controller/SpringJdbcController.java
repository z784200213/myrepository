package com.springboot003.controller;

import com.springboot003.entity.UserInfor;
import com.springboot003.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springjdbc")
public class SpringJdbcController {
    @Autowired
    IUserInforService userInforService;
    @RequestMapping("/index")
    public UserInfor index(){
        UserInfor userInfor=userInforService.query(1);
        return userInfor;
    }
}
