package com.huyhwe.tinyRemind.service;

import com.huyhwe.tinyRemind.model.User;
import com.huyhwe.tinyRemind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.BadLocationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User getUserById(UUID id) {
        Optional<User> userFound = userRepository.findById(id);
        return userFound.orElse(null);
    }

    public void createNewUser(User newUser) {
        if (newUser != null) {
            userRepository.save(newUser);
        }
    }

    public Boolean deleteUserById(UUID id) {
       Optional<User> userToDelete = userRepository.findById(id);
       if (userToDelete.isPresent()) {
           userRepository.delete(userToDelete.get());
           System.out.println("User with id: " + id + " deleted");
           return true;
       } else {
           return false;
       }

    }

    public void updateUser(User userToUpdate) {
        userRepository.save(userToUpdate);
    }
}
