package com.example.moviesappbookingusingapi.Models;

public class User {
    int user_id;
    String email;
    String password;

    public User(int user_id, String email) {
        this.user_id = user_id;
        this.email = email;

    }

    public int getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
