package com.springboot005.controller;

import com.springboot005.entity.UserInfor;
import com.springboot005.exception.BusinessEnum;
import com.springboot005.exception.BusinessException;
import com.springboot005.service.IUserInforService;
import com.springboot005.util.ReflactClass;
import com.springboot005.util.ResponseResult;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**用户操作控制器
 *
 */
@RestController
@RequestMapping("/userInfor")
public class UserInforController {
    @Autowired
    IUserInforService userInforService;

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @GetMapping("/findOne")
    public UserInfor findOne(int id){
        return  userInforService.query(id);
    }

    /**
     * 查询全部用户
     * @return
     */
    @GetMapping("/findAll")
    public ResponseResult<List<UserInfor>> findAll() throws BusinessException, NoSuchFieldException, IllegalAccessException {
        BusinessEnum businessEnum=  BusinessEnum.Order;
        String str= businessEnum.getValue();
        try {
            Object o=null;
            o.toString();
        }catch (Throwable ex){
            ReflactClass reflactClass=new ReflactClass();
            String str1=ex.getMessage();
            String str2=ex.toString();
            throw  new BusinessException(ex.toString());
        }
        return  ResponseResult.success(userInforService.findAll()) ;
    }

    /**
     * 更新用户信息
     * @param userInfor
     * @return
     */
    @PostMapping("/update")
    public  int update(@RequestBody UserInfor userInfor){
        return  userInforService.update(userInfor);
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public  int delete(int id){
        return userInforService.delete(id);
    }

    /**
     * 插入用户信息
     * @param userInfor
     * @return
     */
    @PostMapping("/insert")
    public int insert(UserInfor userInfor){
        return userInforService.insert(userInfor);
    }
    @PostMapping("/login")
    public  boolean login(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpSession session){
        response.addCookie(new Cookie("test","123"));
        Object o=null;
        o.toString();
        return false;
    }
}
