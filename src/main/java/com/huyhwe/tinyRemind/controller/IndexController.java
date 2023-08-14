package com.huyhwe.tinyRemind.controller;

import com.huyhwe.tinyRemind.model.User;
import com.huyhwe.tinyRemind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("userForm",new User());
        return "index";
    }
    @PostMapping("/")
    public String subscribeUser(@ModelAttribute User newUser, Model model){
        userService.createNewUser(newUser);
        System.out.println("user created");
        model.addAttribute("userForm",new User());
        return "index";
//        return "User subscribed!";
    }
}
