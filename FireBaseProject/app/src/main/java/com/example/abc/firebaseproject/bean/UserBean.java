package com.example.abc.firebaseproject.bean;

public class UserBean {

    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserBean(String username, String email) {
        this.username = username;
        this.password = email;
    }
}