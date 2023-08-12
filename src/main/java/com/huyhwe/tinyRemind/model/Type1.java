//package com.huyhwe.tinyRemind.model;
//
//import jakarta.persistence.*;
//
//import java.util.Date;
//import java.util.UUID;
//
//// remind with loop by number of repeats and interval time
//@Entity
//@Table (name = "type1")
//public class Type1 {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;
//
//    Integer time;
//    Date startDate;
//    Integer interval;
//    UUID user_id;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Integer getTime() {
//        return time;
//    }
//
//    public void setTime(Integer time) {
//        this.time = time;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Integer getInterval() {
//        return interval;
//    }
//
//    public void setInterval(Integer interval) {
//        this.interval = interval;
//    }
//
//    public UUID getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(UUID user_id) {
//        this.user_id = user_id;
//    }
//}
