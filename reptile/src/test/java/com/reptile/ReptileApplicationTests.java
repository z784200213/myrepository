package com.reptile;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReptileApplicationTests {

    //注入StringEncryptor
    @Autowired
    StringEncryptor encryptor;
    @Test
    public void contextLoads() throws NoSuchFieldException, IllegalAccessException {
        String username = encryptor.encrypt("root");
        System.out.println(username);
        //加密123
        String password = encryptor.encrypt("123456");

        System.out.println(password);
        String pwd=encryptor.decrypt(password);
        System.out.println(pwd);
        String uname=encryptor.decrypt(username);
        System.out.println(uname);
        ReadOnlyClass readOnlyClass=new ReadOnlyClass();
        Class<?>c=ReadOnlyClass.class;
        Field field=c.getDeclaredField("age");
        field.setAccessible(true);
        field.set(readOnlyClass,12);
        System.out.println(readOnlyClass.getAge());
    }

}
class ReadOnlyClass {
    private Integer age =20;
    public Integer getAge() {
        return age;
    }
}

