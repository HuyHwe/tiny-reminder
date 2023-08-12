package com.huyhwe.tinyRemind.service;

import com.huyhwe.tinyRemind.model.User;
import com.huyhwe.tinyRemind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> userList = (List<User>) userRepository.findAll();
        return userList;
    }

    public void createNewUser(User newUser) {
        userRepository.save(newUser);
    }
}
