package com.springboot003.controller;

import com.springboot003.entity.User;
import com.springboot003.entity.UserInfor;
import com.springboot003.pository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/springjapi")
public class SpringJapiController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/index")
    public User index(){
       List<User>userInfors= userRepository.findAll();
        return  null;
    }
}
