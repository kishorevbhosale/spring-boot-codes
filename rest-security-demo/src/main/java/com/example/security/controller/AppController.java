package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class AppController {

    @GetMapping("/home")
    public String home(){
        return "Hello Spring Secutiry Demo!!!";
    }
}
