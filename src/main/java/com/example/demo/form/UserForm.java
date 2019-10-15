package com.example.demo.form;


public class UserForm {
    private String userName;
    private String email;
    private String password;
    public UserForm() {
 
    }

    public UserForm(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    @Override
    public String toString() {
        return this.userName + "/" + this.password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}