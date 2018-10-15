package com.demo.controller;

import com.demo.common.ApplicationContextUtils;
import com.demo.common.Cache;
import com.demo.common.CacheManager;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/loginin")
    public String login() {
        return "login";
    }

    @PostMapping("/loginPost")
    @ResponseBody
    public Map<String, Object> loginPost(String account, String password, HttpSession session, HttpServletResponse response,
                                         HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();
        Enumeration<String> strings = request.getHeaderNames();
        if (!"123456".equals(password)) {
            map.put("success", false);
            map.put("message", "密码错误");

            map.put("issuccess", false);
            return map;
        }
        Cookie cookie = new Cookie("Loingtoken", "logintoken");
        response.addCookie(cookie);
        long exprisedtime = System.currentTimeMillis() + 1000 * 60;
        CacheManager.putCache("token", new Cache("token", account, exprisedtime, true));
        // 设置session
        session.setAttribute("Testaccount", account);
        session.setAttribute("loginName", account);
        map.put("success", true);
        map.put("message", "登录成功");
        map.put("issuccess", true);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        response.setHeader("token", account);
        System.out.println("目标方法 loginPost");
        Object object = null;
        object.toString();
        return map;
    }
}
