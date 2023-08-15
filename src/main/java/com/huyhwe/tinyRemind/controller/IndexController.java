package com.huyhwe.tinyRemind.controller;

import com.huyhwe.tinyRemind.model.User;
import com.huyhwe.tinyRemind.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("userForm",new User());
        return "index";
    }
    @PostMapping("/success")
    public String subscribeUser(@ModelAttribute User newUser){
        userService.createNewUser(newUser);
        System.out.println("user created");
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
}
