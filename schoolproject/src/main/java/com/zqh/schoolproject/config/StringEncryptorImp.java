package com.zqh.schoolproject.config;

import org.jasypt.encryption.StringEncryptor;


public class StringEncryptorImp implements StringEncryptor {
    @Override
    public String encrypt(String s) {
        return "1";
    }

    @Override
    public String decrypt(String s) {
        return null;
    }
}
