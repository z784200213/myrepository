package com.reptile.controller;

import com.reptile.common.DataResult;
import com.reptile.entity.UserInfor;
import com.reptile.result.ResponseResult;
import com.reptile.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/error")
public class ErrorController extends BaseController {
    @RequestMapping("/error")
    public ResponseResult error() {
        return super.error();
    }

    @Autowired
    IUserInforService userInforService;

    @RequestMapping("/auth")
    public ResponseResult NoAuth(HttpSession session, HttpServletResponse response,
                                 HttpServletRequest request) {

        return super.noAuth();
    }
}
