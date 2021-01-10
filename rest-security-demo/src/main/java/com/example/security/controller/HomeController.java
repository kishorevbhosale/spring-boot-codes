package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noauth")
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "Hi This is public rest call response";
    }
}
