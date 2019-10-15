package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone_Number {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String phone_number;
    private long Profile_id;

    public Phone_Number(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public long getProfile_id() {
        return Profile_id;
    }

    public void setProfile_id(long profile_id) {
        Profile_id = profile_id;
    }

    public Phone_Number(String phone_number, long profile_id) {
        this.phone_number = phone_number;
        Profile_id = profile_id;
    }
    
}