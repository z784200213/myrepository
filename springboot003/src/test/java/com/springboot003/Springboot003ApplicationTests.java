package com.springboot003;

import com.springboot003.entity.HelloSpring;
import com.springboot003.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot003ApplicationTests {

    @Test
    public void contextLoads() {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        HelloSpring hello = (HelloSpring) context.getBean("hellospring");
        IOrderService orderService = (IOrderService) context.getBean("orderservice");
        String str = orderService.getStr();
        System.out.println(str);
        hello.print();
    }

}
