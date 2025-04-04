package com.example.java_spring_mvc_laptopshop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String handleHello() {
        return "Hello from service";
    }
}
