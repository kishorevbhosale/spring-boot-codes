package com.example.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RequestMapping("/user")
public class HomeController {

    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome to USER Home</h1>");
    }

    @GetMapping("/api")
    public String user() {
        return ("<h1>Welcome to User API</h1>");
    }
}
