package com.example.demo.models;

import java.sql.Date;

public class Employee {
    private long id;
    private String name;
    private Date joining_date;
    private long salary;
    private String post;

    public Employee(long id, String name, Date joining_date, long salary, String post) {
        this.id = id;
        this.name = name;
        this.joining_date = joining_date;
        this.salary = salary;
        this.post = post;
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

    public Date getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Date joining_date) {
        this.joining_date = joining_date;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
    
}