package com.demo.exception;

public class ResultUtil {
    public ResultUtil() {

    }

    public static Msg error(int i, String msg) {
        return new Msg(i, msg);
    }
}
