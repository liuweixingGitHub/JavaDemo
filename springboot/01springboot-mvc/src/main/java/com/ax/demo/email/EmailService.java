package com.ax.demo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {

    @Value(value = "${spring.mail.username}")
    private String username;


    @Autowired
    private JavaMailSenderImpl javaMailSender;

    //简单邮件测试
    public Object sendTextEmail(String email) {

        System.out.println("username = " + username);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("email测试");
        message.setText("邮件测试内容");
        message.setTo(email);
        /*必须有发送方*/
        message.setFrom(username);
        try {
            javaMailSender.send(message);
            System.out.println("发送成功");
            return "发送成功";
        } catch (MailException e) {
            System.out.println("e = " + e);
            return "发送失败" + e.getMessage();
        }

    }


    //复杂邮件测试
    public void sendComplicated() throws MessagingException {
        //创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //用MimeMessageHelper来包装MimeMessage
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("email测试");
        mimeMessageHelper.setText("邮件测试内容");
        mimeMessageHelper.setTo("fanqixxxx@vip.qq.com");
        mimeMessageHelper.setFrom("fanqixxxx@163.com");
        mimeMessageHelper.addAttachment("meinv.jpg", new File("D:\\meinv.jpg"));
        javaMailSender.send(mimeMessage);

    }
}