package com.demo.exception;

public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    UNDER_AGE(100,"未成年"),
    OLDNESS(101,"年龄超过60岁")
    ;
    private Integer code;

    private String message;

     ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
