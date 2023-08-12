package com.huyhwe.tinyRemind.controller;

import com.huyhwe.tinyRemind.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mailSendingController {
    @Autowired
    MailSenderService mailSenderService;
    @GetMapping("/")
    public String sendMailDemo() {
        mailSenderService.sendEmail("nguyenduchuy564@gmail.com", "important", "nono");
        return "mail sent";
    }
}
