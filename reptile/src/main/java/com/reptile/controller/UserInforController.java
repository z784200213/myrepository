package com.reptile.controller;

import com.reptile.aspect.WebDesc;
import com.reptile.common.DataResult;
import com.reptile.common.ResponseBeanType;
import com.reptile.redis.RedisTool;
import com.reptile.reflect.ClassUtil;
import com.reptile.result.ResponseResult;
import com.reptile.entity.UserInfor;
import com.reptile.service.IUserInforService;
import com.reptile.util.FtpUtil;
import com.reptile.util.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.ServiceLoader;

@RestController
@RequestMapping("/userinfor")
public class UserInforController {
    @Autowired
    IUserInforService userInforService;
    @Autowired
    FtpUtil ftpUtil;

    @RequestMapping("/query")
    public DataResult query(int id) {
        DataResult<UserInfor> dataResult = new DataResult<UserInfor>();
        UserInfor userInfor = userInforService.query(id);
        dataResult.setData(userInfor);
        dataResult.setResponse("", 0, ResponseBeanType.SUCCESS);

        return dataResult;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public DataResult Login(@RequestBody UserInfor userInfor, HttpSession session, HttpServletResponse response,
                            HttpServletRequest request) throws IOException {
        UserInfor user = null;
        if (userInfor != null) {
            user = userInforService.query(userInfor.getId());
        }
        if (user != null) {

        }
        session.setAttribute("logintoken", userInfor.getName());
        DataResult dataResult = new DataResult();
        ftpUtil.CheckLogin();
        return dataResult;
    }

    @RequestMapping("/test")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult Test() {
        ResponseResult responseResult = new ResponseResult();
        try {
            UserInfor userInfor = new UserInfor();
            userInfor.setId(2);
            userInfor.setAge(15);
            userInfor.setName("zhangsan");
            int i = userInforService.AddUserInfo(userInfor);
          /*  Object object=null;
            object.toString();*/
            responseResult.success("123");
            return responseResult;
        } catch (Exception ex) {
            ex.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//就是这一句了，加上之后，如果方法1抛了异常,
        }
        return responseResult;
    }

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    RedisTool redisTool;
    @Autowired
    MyBean myBean;

    @RequestMapping("/test1")
    @Transactional
    @WebDesc
    public ResponseResult Testtranc() {
        ResponseResult responseResult = new ResponseResult();

        UserInfor userInfor = new UserInfor();
        userInfor.setId(2);
        userInfor.setAge(15);
        userInfor.setName("zhangsan");
        int i = userInforService.AddUserInfo(userInfor);
           /* Object object=null;
            object.toString();*/
        //redisTool.set("zhang","san");
        responseResult.success("123");
        return responseResult;
    }

    @RequestMapping("/setredis")
    public void setRedis() {
        redisTemplate.opsForValue().set("name", "guanguan");
        redisTool.set("key", "san");
    }

    @RequestMapping("/getredis")
    public String getRedis() {

        String str = redisTool.get("key").toString();
        ApplicationContext applicationContext = myBean.getContext();
        Map<String, IUserInforService> map = applicationContext.getBeansOfType(IUserInforService.class);

        ClassUtil.getAllClassByInterface(IUserInforService.class);
        return str;
    }
}
