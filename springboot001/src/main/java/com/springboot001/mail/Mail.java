package com.springboot001.mail;

import com.springboot001.entity.MailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;


import java.util.Properties;

@Component
public class Mail {
    @Autowired
    JavaMailSender jms;

    /**
     * 使用JavaMailSender发送邮件
     *
     * @param senderMisaddress 发送方邮箱地址
     * @param toMisaddress     接收方邮箱地址
     * @param title             标题
     * @param content           内容
     */
    public void sedemail(String senderMisaddress, String toMisaddress, String title, String content) {
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom(senderMisaddress);
        //接收者
        mainMessage.setTo(toMisaddress);
        //发送的标题
        mainMessage.setSubject(title);
        //发送的内容
        mainMessage.setText(content);
        jms.send(mainMessage);
    }

    /**
     *读取配置中的邮箱相关信息的设置
     * 协议、端口等等
     */
    @Autowired
    MailEntity mailEntity;
    /**
     *
     * @param subject 标题
     * @param content 内容
     * @param to       接收邮件的邮箱地址
     */
    public void sendMail(String subject, String content, String to) {
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", mailEntity.getHost());
        props.setProperty("mail.transport.protocol", mailEntity.getProtocol());
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(props);
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(mailEntity.getUsername()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=utf-8");
            Transport transport = session.getTransport();
            transport.connect(mailEntity.getHost(), mailEntity.getUsername(), mailEntity.getPassword());
            transport.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("邮件发送失败...");
        }
    }
}
