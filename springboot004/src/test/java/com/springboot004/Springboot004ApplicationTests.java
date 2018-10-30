package com.springboot004;

import com.springboot004.util.AESUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.krb5.internal.crypto.Aes128;

@RunWith(SpringRunner.class)
@SpringBootTest

public class Springboot004ApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        String str=AESUtil.aesEncrypt("root");
        System.out.println(str);
        String pwd=AESUtil.aesEncrypt("123456");
        System.out.println(pwd);
      String str1=  AESUtil.aesDecrypt(str);
    }

}
