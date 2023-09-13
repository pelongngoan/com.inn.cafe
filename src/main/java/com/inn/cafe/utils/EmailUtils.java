package com.inn.cafe.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class EmailUtils {
    @Autowired
    private JavaMailSender emailSender;
    public void sendSimpleMessage(String to, String subject, String text, List<String> list){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("long.tl446@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        if (list!=null && list.size()>0) {
            message.setCc(getCcArray(list));
        }
        emailSender.send(message);
    }

    private String[] getCcArray(List<String> ccList){
        String[] cc = new String[ccList.size()];
        for (int i=0; i<ccList.size();i++){
            cc[i]=ccList.get(i);
        }
        return cc;
    }

    public void forgotMail(String to, String subject, String password) throws MessagingException{
        System.out.println("a1");
        MimeMessage message = emailSender.createMimeMessage();
        System.out.println("a2");
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        System.out.println("a3");
        helper.setFrom("long.tl446@gmail.com");
        System.out.println("a4");
        helper.setTo(to);
        System.out.println("a5");
        helper.setSubject(subject);
        System.out.println("a6");
        String htmlMsg = "<p><b>Your Login details for Cafe Management System</b><br><b>Email: </b> " + to + " <br><b>Password: </b> " + password + "<br><a href=\"http://localhost:4200/\">Click here to login</a></p>";
        message.setContent(htmlMsg,"text/html");
        System.out.println("a7");
        emailSender.send(message);
    }
}
