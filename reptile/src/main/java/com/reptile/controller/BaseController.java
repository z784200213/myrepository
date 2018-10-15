package com.reptile.controller;

import com.reptile.common.DataResult;
import com.reptile.result.ResponseResult;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController<T> {
    private ResponseResult responseResult = new ResponseResult();

    protected ResponseResult success(T data) {
        return responseResult.success(data);
    }

    protected ResponseResult error() {
        return responseResult.error();
    }

    protected ResponseResult exception(T data) {
        return responseResult.exception(data);
    }

    protected ResponseResult fail(T data) {
        return responseResult.fail(data);
    }

    protected ResponseResult noAuth() {
        return responseResult.noAuth();
    }
}
