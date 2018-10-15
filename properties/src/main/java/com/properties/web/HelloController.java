package com.properties.web;

import com.properties.common.ReadConfig;
import com.properties.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    BlogProperties blogProperties;
    @Autowired
    ApplicationContextUtils applicationContextUtils;
    @Autowired
    ReadConfig readConfig;
    @RequestMapping( "/index")
    public BlogProperties index() {
        ApplicationContext applicationContext=applicationContextUtils.getContext();
        FooProperties foo =readConfig.read("com.test",FooProperties.class);// binder.bind("com.didispace", Bindable.of(FooProperties.class)).get();
        System.out.println(foo.getFoo());
        return  blogProperties;
    }
    @RequestMapping("/getUserInfor")
    public List<UserInfor> getUserInfor(){
        readConfig.getPostinfos();
        List<UserInfor>userInfors=readConfig.reads("com.test.userinfors",UserInfor.class);
        return userInfors;
    }
}
