package com.example.spring.data.jpa.dao;

import com.example.spring.data.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {

    public List<User> findByProfession(String profession); // CaseSensitive

    public Long countByAge(int age);

    public List<User> deleteByName(String name);

    //MultiCondition
    public List<User> findByProfessionAndAge(String profession,int age);

    // Case-Insesitive
    public List<User> findByProfessionIgnoreCase(String profession);

    //Custom Query
    @Modifying
    @Query("select u from User u")
    public List<User> getUserCustomQuery();

}
