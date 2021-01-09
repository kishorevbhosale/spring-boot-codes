package com.example.spring.data.jpa.service;

import com.example.spring.data.jpa.dao.UserRepo;
import com.example.spring.data.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    public void initDB() {
        List<User> users = new ArrayList<>();
        users.add(new User(111,"ajay","IT",23));
        users.add(new User(675,"vijay","CIVIL",24));
        users.add(new User(432,"sujay","MECH",26));
        users.add(new User(88,"prakash","IT",23));
        userRepo.saveAll(users);
    }
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public List<User> getUsersByProfession(String profession){
        return userRepo.findByProfession(profession);
    }

    public long getCountByAge(int age){
        return userRepo.countByAge(age);
    }

    public List<User> deleteUser(String name){
        return userRepo.deleteByName(name);
    }

    public List<User> getUserWithProfessionAndAge(String profession,int age){
        return userRepo.findByProfessionAndAge(profession,age);
    }

    // Case insensitive sorting
    public List<User> getUserWithProfessionIgnoreCase(String profession){
        return userRepo.findByProfessionIgnoreCase(profession);
    }

    // Sort by field
    public List<User> getSortedUser(String field){
        return userRepo.findAll(Sort.by(field));
    }

    // Sort by multiplefields and with sorting criteria
    public List<User> getSortedUserBasedOnMultipleFields(String field1,String field2){
        return userRepo.findAll(Sort.by(field1).descending().and(Sort.by(field2)));
    }

    //Pagination
    public Page<User> getPagination(int page, int size){
        return userRepo.findAll(PageRequest.of(page, size));
    }

    public List<User> getCustomQuery(){
        return userRepo.getUserCustomQuery();
    }

}
