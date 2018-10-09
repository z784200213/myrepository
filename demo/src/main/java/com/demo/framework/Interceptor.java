package com.demo.framework;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
       /* if(arg3!=null){
            System.out.println( arg3.getMessage()+arg3.getStackTrace());
        }*/
        System.out.println("afterCompletion 方法");
        // TODO Auto-generated method stub
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

        System.out.println("postHandle 方法");
        // TODO Auto-generated method stub
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        System.out.println("preHandle 方法");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        System.err.println("------------------>:已完成跨域处理");
        return true;

    }
}
