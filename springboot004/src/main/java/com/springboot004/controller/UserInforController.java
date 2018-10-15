package com.springboot004.controller;

import com.springboot004.entity.UserInfor;
import com.springboot004.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/userinfor")
public class UserInforController {
    @Autowired
    DataSource dataSource;
    public  UserInforController(){

    }
    @Autowired
    IUserInforService userInforService;
    @GetMapping("/index")
    public UserInfor index(int id) throws SQLException {
        UserInfor userInfor=userInforService.query(id);
        Connection connection= dataSource.getConnection();
        return  userInfor;
    }
}
