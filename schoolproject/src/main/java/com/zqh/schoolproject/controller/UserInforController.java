package com.zqh.schoolproject.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zqh.schoolproject.common.MysqlConfig;
import com.zqh.schoolproject.common.ResponseBean;
import com.zqh.schoolproject.entity.UserInfo;
import com.zqh.schoolproject.service.IUserInforService;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserInfor")
public class UserInforController {
    @Autowired
    IUserInforService userInforService;
    @Autowired
    MysqlConfig mySQLConfig;

    //注入StringEncryptor
   /* @Autowired
    StringEncryptor encryptor;*/
    @RequestMapping("/Query/id={id}")
    public UserInfo Query(@PathVariable int id) {
        return userInforService.Query(id);
    }

    @RequestMapping("/QueryWithCars/id={id}")
    public UserInfo QueryWithCars(@PathVariable int id) {
      /*  StringEncryptor stringEncryptor=new StandardPBEStringEncryptor();
        String username = stringEncryptor.encrypt("root");
        System.out.println(username);
        //加密123
        String password = stringEncryptor.encrypt("123");
        System.out.println(password);
      //  System.out.println(mySQLConfig.getPassword());*/
        return userInforService.QueryInculdCar(id);
    }

    @RequestMapping(value = "/AddUserInfo", method = RequestMethod.POST)
    public ResponseBean AddUserInfor(@RequestBody UserInfo userInfo) {
        ResponseBean bean = new ResponseBean();
        try {
            userInforService.AddUserInfor(userInfo);
            bean.setSuccessResponse("操作成功");
            return bean;

        } catch (Exception ex) {
            bean.setExceptionResponse(ex.getMessage());
            return bean;
        }


    }
}
