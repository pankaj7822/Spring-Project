package com.example.demo.services;

import java.util.List;

public interface StationaryService {
        
        void addAStationary(String item_type,long stock,String brand, long selling_price, long marked_price, long discounted_price );   
        void deleteAStationary(String item_type, Long id);
        void updateStationaryStock(String item_type,Long id,Long stock);
        List  ListStationary();
        
}