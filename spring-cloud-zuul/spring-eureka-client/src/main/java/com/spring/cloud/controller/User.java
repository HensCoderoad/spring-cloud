package com.spring.cloud.controller;

/**
 * @author : Hens
 * @date : 2019/9/25 20:31
 */
public class User {

    private String username;

    private String address;

    public User(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
