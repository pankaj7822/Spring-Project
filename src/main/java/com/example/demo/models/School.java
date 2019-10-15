package com.example.demo.models;

public class School{
    private long id;
    private String name;
    private String phone_number;
    private String agent_name;
    private String address;

    public School(long id, String name, String phone_number, String agent_name, String address) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
        this.agent_name = agent_name;
        this.address = address;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}