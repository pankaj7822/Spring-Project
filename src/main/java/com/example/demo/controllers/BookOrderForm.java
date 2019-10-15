package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.Book;

public class BookOrderForm {
    private List<Book> book;
    private List<Long> quantities;

    public BookOrderForm(List<Book> book, List<Long> quantities) {
            this.book = book;
            this.quantities = quantities;
    }

    public List<Book> getBook() {
            return book;
    }

    public void setBook(List<Book> book) {
            this.book = book;
    }

    public List<Long> getQuantities() {
            return quantities;
    }

    public void setQuantities(List<Long> quantities) {
            this.quantities = quantities;
    }
}