package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Profile;

public interface DashBoardService {
        Profile getProfileByUserName(String username);
        void updateProfile(String name,Long id);
        void addAddress(String state,String district,String city,String pincode,String landmark,Long profileid);
        void updateAddress(String state,String district,String city,String pincode,String landmark,Long id);
        void addPhoneNumber(String phone_number, Long profileid);
        void updatePhoneNumber(String phone_number,Long id);
        List  ListAddress(Long profileid);
        List  ListPhoneNumber(Long profileid);  
}