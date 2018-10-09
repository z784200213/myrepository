package com.annotationtest.controller;

import com.alibaba.fastjson.JSON;
import com.annotationtest.Result.DataResult;
import com.annotationtest.Result.ResponseBean;
import com.annotationtest.common.AnnoTest;
import com.annotationtest.common.TestAnno;
import com.annotationtest.common.WebDesc;
import com.annotationtest.entity.UserInfor;
import com.annotationtest.json.JsonData;
import com.annotationtest.service.IUserInforService;
import com.annotationtest.utils.FtpSocket;
import com.annotationtest.utils.FtpUtil;
import com.annotationtest.utils.RedisTool;
import com.annotationtest.utils.RedisUtil;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aop2")
public class UserInforController {
  /*  @Value("classpath:static/data/test.json")
    UserInfor userInfor;*/
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    RedisTool redisTool;
    @Autowired
    IUserInforService userInforService;
    @RequestMapping("/testAnnotation")
    @WebDesc(describe = "This is testAnnotation Controller testAnnotation")
    public ResponseBean testAnnotation(String key){
        ResponseBean responseBean=new ResponseBean();
        Object object=null;
        object.toString();
      //  responseBean.setSuccessResponse("测试");
        return responseBean;//"key="+key;
    }
    @RequestMapping("/testAnnotation1")
    public  String WithoutAnnotation(){
        return  "没有使用注解";
    }
    @RequestMapping("/returnboolean")
    @WebDesc()
    public  boolean ReturnBoolean(){
        return  false;
    }
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping("/returnlist")
    @TestAnno()
    public DataResult<List<String>> ReturnList(){
        return getListDataResult();

    }

    private DataResult<List<String>> getListDataResult() {
        List<String>list=new ArrayList<String>();
        list.add("1");
        list.add("测试");
        UserInfor u1=new UserInfor();
        u1.setId(1);
        u1.setNick_name("张三");
        u1.setAddress_id(2);
        userInforService.Add(u1);
        UserInfor u2=new UserInfor();
        u2.setId(1);
        u1.setNick_name("张三1");
        u1.setAddress_id(2);
        userInforService.Add(u2);
        return new  DataResult<List<String>>(list);
    }

    @Transactional
    @RequestMapping("/returnlist1")
    @AnnoTest()
    public DataResult<List<String>> ReturnList1(){
        return getListDataResult();

    }
    @RequestMapping("/redisset")
    public List<String>RedisSet(){
        List<String>str=new ArrayList<String>();
        str.add("测试1");
        str.add("测试2");
        Object obj= JSON.toJSON(str).toString();
        redisTool.set("key",str);
        return str;
    }
    @RequestMapping("/redisget")
    public Object RedisGet(){
        List<UserInfor>  list=  JsonData.jsonDataString();
        Object str=  redisTool.get("key");
        return str;
    }
    @RequestMapping("/getlist/id={id}")
    @Cacheable(key = "id")
    public  List<String>Getlist(String id){
        List<String>list=new ArrayList<String>();
        list.add("人");
        System.out.println("没有调用缓存");
        return  list;
    }
    @RequestMapping("/query/id={id}")
    public UserInfor Query(@PathVariable int id){
     UserInfor userInfor=   userInforService.Query(id);
     System.out.println("调用缓存");
        return userInfor;
    }
    @RequestMapping("/person")
    public String toPerson(String name,int age){
        System.out.println(name+" "+age);
        return "hello";
    }
    @Autowired
    FtpUtil ftpUtil;
@RequestMapping("/ftp")
    public void  FtpTest() throws IOException {
    ftpUtil.CheckLogin();
    }
    @Autowired
    FtpSocket ftpSocket;
    @RequestMapping("/ftpsocket")
    public  void  ftpSocket() throws IOException {
           // ftpSocket.connect("172.17.13.36",2121,"ftpuser","1");
            ftpSocket.userUrl();
    }
}
