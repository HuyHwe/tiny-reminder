package com.huyhwe.tinyRemind.controller;

import com.huyhwe.tinyRemind.model.User;
import com.huyhwe.tinyRemind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/new")
    public void createNewUser(@RequestBody User newUser){
        userService.createNewUser(newUser);
    }
}
