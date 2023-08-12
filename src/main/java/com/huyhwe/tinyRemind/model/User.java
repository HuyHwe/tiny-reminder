package com.huyhwe.tinyRemind.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String email;

//    Long type;
    public UUID getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//    public Long getType() {
//        return type;
//    }
//
//    public void setType(Long type) {
//        this.type = type;
//    }

}