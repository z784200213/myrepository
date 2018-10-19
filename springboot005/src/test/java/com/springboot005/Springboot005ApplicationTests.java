package com.springboot005;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot005ApplicationTests {

    @Test
    public void contextLoads() {
        List<Integer>data=new ArrayList<Integer>();
        List<Integer>mins=new ArrayList<Integer>();

    }

    private void testReflact() {
        try {
                  /* String str=   ResourceUtils.getURL("classpath:").getPath();
                System.out.println(str);*/
            PrivateObject privateObject = new PrivateObject("The Private Value");
            Method privateStringMethod = privateObject.getClass().//PrivateObject.class.
                    getDeclaredMethod("getPrivateString", null);
            privateStringMethod.setAccessible(true);
            String returnValue = (String)
                    privateStringMethod.invoke(privateObject, null);
            System.out.println("returnValue = " + returnValue);
            Field field = privateObject.getClass().getDeclaredField("privateString");//PrivateObject.class.getDeclaredField("privateString");
            field.setAccessible(true);
            String str = (String) field.get(privateObject);
            System.out.println(str);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

