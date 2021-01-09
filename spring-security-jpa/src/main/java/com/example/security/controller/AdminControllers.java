package com.example.security.controller;

import com.example.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdminControllers {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome to ADMIN Home</h1>");
    }

    @GetMapping("/api")
    public String getName(){
        return "Welcome to ADMIN API : -"+userRepository.getOne(1).getUserName();
    }
}
