package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String author;
    private String level;
    private long selling_price;
    private long marked_price;
    private long discounted_price;
    private long stock;
    private String edition;
    private String genre;

    public Book(){

    }

    public Book(long id, String name, String author, String level, long selling_price, long marked_price,
            long discounted_price, long stock, String edition, String genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.level = level;
        this.selling_price = selling_price;
        this.marked_price = marked_price;
        this.discounted_price = discounted_price;
        this.stock = stock;
        this.edition = edition;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}