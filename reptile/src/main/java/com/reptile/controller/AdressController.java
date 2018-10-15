package com.reptile.controller;

import com.reptile.entity.UserInfor;
import com.reptile.result.ResponseResult;
import com.reptile.service.IUserInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AdressController extends BaseController {
    @Autowired
    IUserInforService userInforService;

    @RequestMapping("/query")
    public ResponseResult query(int id) {

        ResponseResult responseResult = super.success(userInforService.query(id));
        return responseResult;
    }
}
