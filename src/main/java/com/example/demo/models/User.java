package com.example.demo.models;

public class User {
 
    private Long userId;
    private String userName;
    private String encryptedPassword;
    private String email;

    public User() {
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public User(Long userId, String userName, String encryptedPassword, String email ) {
        this.userId = userId;
        this.userName = userName;
        this.encryptedPassword = encryptedPassword;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getencryptedPassword() {
        return encryptedPassword;
    }
    public void setencryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    @Override
    public String toString() {
        return this.userName + "/" + this.encryptedPassword;
    }
}