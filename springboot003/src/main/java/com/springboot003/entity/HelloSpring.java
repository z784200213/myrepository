package com.springboot003.entity;

public class HelloSpring {
    private String str;
    public void print() {
        System.out.println("Hello!    " + this.getStr());
    }
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
