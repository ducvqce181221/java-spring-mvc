package com.example.java_spring_mvc_laptopshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Hello World from Vu Quang Duc 2025!";
    }

    @GetMapping("/user")
    public String usePage() {
        return "Only user access this page 2025.";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "Only admin access this page 2025.";
    }

}
