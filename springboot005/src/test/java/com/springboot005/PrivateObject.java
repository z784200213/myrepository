package com.springboot005;

public class PrivateObject {
    private String privateString = null;

    public PrivateObject(String privateString) {
        this.privateString = privateString;
    }

    private String getPrivateString() {//私有方法
        return this.privateString;
    }
}
