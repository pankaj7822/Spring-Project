package com.example.demo.services;

import java.util.List;

public interface BookService {
        
        void addABook(String name, String author, String level, long selling_price, long marked_price, long discounted_price, long stock, String edition, String genre);   
        void deleteABook(String name, Long id);
        void updateBookStock(String name,Long id,Long stock);
        List  ListBook();
        
}