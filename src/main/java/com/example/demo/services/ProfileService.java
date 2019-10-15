package com.example.demo.services;

import java.util.List;

public interface ProfileService {
        
        void addAProfile(String name, Long points, Long User_id);   
        void deleteAProfile(String name, Long id);
        void updateProfilePoint(String name,Long id,Long points);
        List  ListProfile();
        
}