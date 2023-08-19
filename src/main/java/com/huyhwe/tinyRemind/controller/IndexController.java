package com.huyhwe.tinyRemind.controller;

import com.huyhwe.tinyRemind.model.User;
import com.huyhwe.tinyRemind.service.MailSenderService;
import com.huyhwe.tinyRemind.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @Autowired
    MailSenderService mailSenderService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("userForm",new User());
        return "index";
    }
    @PostMapping("/success")
    public String subscribeUser(@ModelAttribute User newUser, Model model){
        new Thread(new Runnable() {
            @Override public void run() {
                userService.createNewUser(newUser);
                System.out.println("user created");
                mailSenderService.sendRawEmail(newUser.getEmail(), "Hydrated confirmation", "Hello " + newUser.getName()+ "! Please confirm your email address by clicking this link: " +" http://localhost:3008/confirm/" + newUser.getId() +  "\nStay hydrated!");
            }
        }).start();
        model.addAttribute("name", newUser.getName());
        model.addAttribute("email", newUser.getEmail());
        return "success";
    }

    @GetMapping("/unsubscribe/{id}")
    public String unsubscribeUser (@PathVariable UUID id) {
        if (userService.deleteUserById(id)) {
            return "unsubscribed";
        } else {
            return "error";
        }
    }
    @GetMapping("/confirm/{id}")
    public String confirmEmail (@PathVariable UUID id, Model model) {
        User userCheck = userService.getUserById(id);
        if (userCheck!=null) {
            userCheck.setVerified(Boolean.TRUE);
            userService.updateUser(userCheck);
            model.addAttribute("name", userCheck.getName());
            return "confirmed";
        } else {
            return "error";
        }
    }
}
