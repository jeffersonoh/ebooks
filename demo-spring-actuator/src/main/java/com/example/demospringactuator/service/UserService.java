package com.example.demospringactuator.service;

import com.example.demospringactuator.domain.user.Users;

import java.util.List;

public interface UserService {

    Users saveUser(Users user);
    Users findByUsername(String userName);
    List<Users> findAll();
}
