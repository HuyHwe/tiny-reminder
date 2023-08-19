package com.huyhwe.tinyRemind.service;
import com.huyhwe.tinyRemind.model.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.naming.*;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;

@Service
public class MailSenderService {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    TemplateEngine templateEngine;


    public void sendEmail(User user) throws MessagingException {
        org.thymeleaf.context.Context context = new Context();
        context.setVariable("name", user.getName());
        context.setVariable("unsubLink", "http://localhost:3008/unsubscribe/"+user.getId());
        String process = templateEngine.process("hydrate", context);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("tinyreminderr@gmail.com");
        helper.setTo(user.getEmail());
        helper.setSubject("Stay hydrate " + user.getName() + "!");
        helper.setText(process, true);
        javaMailSender.send(message);
        System.out.println("mail sent");
    }

    public void sendRawEmail(String toEmail, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tinyreminderr@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }


}
