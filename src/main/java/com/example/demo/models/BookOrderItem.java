package com.example.demo.models;
public class BookOrderItem {

    private Long id;
    private Long quantity;
    private Order order;
    private Book book;


    public BookOrderItem(Long id, Long quantity, Order order, Book book) {
        this.id = id;
        this.quantity = quantity;
        this.order = order;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
}