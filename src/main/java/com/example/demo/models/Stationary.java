package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stationary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String item_type;
    private long stock;
    private String brand;
    private long selling_price;
    private long marked_price;
    private long discounted_price;


 
    public Stationary() {
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(long selling_price) {
        this.selling_price = selling_price;
    }

    public long getMarked_price() {
        return marked_price;
    }

    public void setMarked_price(long marked_price) {
        this.marked_price = marked_price;
    }

    public long getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(long discounted_price) {
        this.discounted_price = discounted_price;
    }

  

    public Stationary(long id, String item_type, long stock, String brand, long selling_price, long marked_price,
        long discounted_price) {
        this.id = id;
        this.brand = brand;
        this.item_type = item_type;
        this.stock = stock;
        this.selling_price = selling_price;
        this.marked_price = marked_price;
        this.discounted_price = discounted_price;
    }
}