package com.example.spring.data.jpa.controller;

import com.example.spring.data.jpa.model.User;
import com.example.spring.data.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/spring-data-jpa")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/getUsersByProfession/{profession}")
    public List<User> getAllUsersByProfession(@PathVariable String profession){
        return userService.getUsersByProfession(profession);
    }

    @GetMapping("/getUserCount/{age}")
    public String getUserCountByAge(@PathVariable  int age){
        long count = userService.getCountByAge(age);
        return "Total number of records of age "+age+" : "+count;
    }

    @DeleteMapping("/delete/{name}")
    public List<User> deleteUser(@PathVariable String name){
        return userService.deleteUser(name);
    }

    @GetMapping("/getUsersByProfessionAndAge/{profession}/{age}")
    public List<User> getAllUsersByProfessionAndAge(@PathVariable String profession, @PathVariable int age){
        return userService.getUserWithProfessionAndAge(profession,age);
    }

    @GetMapping("/getUsersByProfessionIgnoreCase/{profession}")
    public List<User> getAllUsersByProfessionIgnoreCase(@PathVariable String profession){
        return userService.getUserWithProfessionIgnoreCase(profession);
    }

    @GetMapping("/getSortedUsers/{field}")
    public List<User> getSortedUsers(@PathVariable String field){
        return userService.getSortedUser(field);
    }

    @GetMapping("/getMultiSortedUsers/{field1}/{field2}")
    public List<User> getSortedUserBasedOnMultipleFields(@PathVariable String field1,@PathVariable String field2){
        return userService.getSortedUserBasedOnMultipleFields(field1,field2);
    }

    @GetMapping("/pagination/{page}/{size}")
    public Page<User> getPagination(@PathVariable int page, @PathVariable int size){
        return userService.getPagination(page,size);
    }

    @GetMapping(value="/customquery")
    public  List<User> getCustomUsers(){
        return userService.getCustomQuery();
    }

}
