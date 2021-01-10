package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class RestSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSecurityApplication.class, args);
	}

}
