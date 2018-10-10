package com.springboot001.web;

import com.springboot001.entity.MailEntity;
import com.springboot001.exception.MyException;
import com.springboot001.mail.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
@Autowired
JavaMailSender jms;
    @Autowired
    MailEntity entity;
    @Autowired
    Mail mail;
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        testSend2();
        return "test";
    }
    private  void TestSend1(){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom(****);
        //接收者
        mainMessage.setTo(****);
        //发送的标题
        mainMessage.setSubject("嗨喽");
        //发送的内容
        mainMessage.setText("hello world");

        jms.send(mainMessage);
    }
    private  void testSend2(){
        mail.sendMail("测试","163信息发送到qq邮箱中","784200213@qq.com");
    }
}
