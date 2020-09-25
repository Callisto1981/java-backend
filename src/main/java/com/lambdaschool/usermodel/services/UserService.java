package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.models.User;

import java.util.List;


public interface UserService
{

    List<User> findAll();


    List<User> findByNameContaining(String username);


    User findUserById(long id);


    User findByName(String name);


    void delete(long id);


    User save(User user);


    User update(
            User user,
            long id);


    public void deleteAll();
}