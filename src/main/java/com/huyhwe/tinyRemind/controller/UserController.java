package com.huyhwe.tinyRemind.controller;

import com.huyhwe.tinyRemind.model.User;
import com.huyhwe.tinyRemind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/allMail")
    public ArrayList<String> getAllUserMails() {
        ArrayList<User> userList = userService.getAllUsers();
        ArrayList<String> mailList = new ArrayList<>();
        userList.forEach(user -> {
            mailList.add(user.getEmail());
        });
        return mailList;
    }

//    @PostMapping("/new")
//    public void subscribeUser(@ModelAttribute User newUser){
//        userService.createNewUser(newUser);
////        return "User subscribed!";
//    }

    @DeleteMapping("/remove/{id}")
    public String unsubscribeUser(@PathVariable UUID id) {
        if(userService.deleteUserById(id)) {
            return "User unsubscribed!";
        } else {
            return "Something gone wrong!";
        }
    }
}
