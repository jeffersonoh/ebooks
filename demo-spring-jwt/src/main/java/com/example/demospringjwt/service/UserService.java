package com.example.demospringjwt.service;

import com.example.demospringjwt.domain.user.Users;

import java.util.List;

public interface UserService {

    Users saveUser(Users user);
    Users findByUsername(String userName);
    List<Users> findAll();
}
