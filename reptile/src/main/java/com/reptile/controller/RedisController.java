package com.reptile.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.reptile.entity.UserInfor;
import com.reptile.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/setObject")
    public void setObject() throws JsonProcessingException {
        UserInfor userInfor = new UserInfor();
        userInfor.setName("李白");
        userInfor.setId(12);
        userInfor.setAge(12);
        String s = JsonUtil.convertObj2String(userInfor);
        stringRedisTemplate.opsForValue().set("libai", s);
    }

    @RequestMapping("/getObject")
    public void getObject() throws IOException {
        String s = stringRedisTemplate.opsForValue().get("libai");
        UserInfor userInfor = new UserInfor();
        userInfor = JsonUtil.convertString2Obj(s, UserInfor.class);
        String s1 = s;
    }
    @RequestMapping("/setObjects")
    public void setObjects() throws JsonProcessingException {
        List<UserInfor>userInfors=new ArrayList<UserInfor>();
        UserInfor userInfor = new UserInfor();
        userInfor.setName("李白");
        userInfor.setId(12);
        userInfor.setAge(12);
        userInfors.add(userInfor);
        UserInfor userInfor1=new UserInfor();
        userInfor1.setAge(13);
        userInfor1.setId(13);
        userInfor1.setName("王维");
        userInfors.add(userInfor1);
        String s = JsonUtil.convertObj2String(userInfors);
        stringRedisTemplate.opsForValue().set("shiren", s);
    }
    @RequestMapping("/getObjects")
    public UserInfor[] getObjects() throws IOException {
        String s = stringRedisTemplate.opsForValue().get("shiren");

        UserInfor[] userInfors = JsonUtil.convertString2list(s, UserInfor[].class);

        String s1 = s;
       return userInfors;
    }
}
