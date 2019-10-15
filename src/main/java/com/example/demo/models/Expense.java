package com.example.demo.models;

import java.sql.Date;

public class Expense {

    private long id;
    private String service;
    private long amount;
    private Date date_of_expense;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getDate_of_expense() {
        return date_of_expense;
    }

    public void setDate_of_expense(Date date_of_expense) {
        this.date_of_expense = date_of_expense;
    }

    public Expense(long id, String service, long amount, Date date_of_expense) {
        this.id = id;
        this.service = service;
        this.amount = amount;
        this.date_of_expense = date_of_expense;
    }

    
    
}