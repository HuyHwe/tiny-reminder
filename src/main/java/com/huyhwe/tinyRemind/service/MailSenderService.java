package com.huyhwe.tinyRemind.service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;

@Service
public class MailSenderService {
    @Autowired
    JavaMailSender javaMailSender;


    public void sendEmail(String toEmail,
                          String subject,
                          String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tinyreminderr@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        System.out.println("mail sent");
    }

    public void sendHTMLMail(String toEmail) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            // set mediaType
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            helper.setTo(toEmail);
            helper.setText("<h1>Hello</h1> <h3>test</h3>", true);
            helper.setSubject("Reminder");
            helper.setFrom("tinyreminderr@gmail.com");
            javaMailSender.send(message);

        } catch (MessagingException e) {
            System.out.println("Mail Sending failure : "+e.getMessage());
        }

    }

}
