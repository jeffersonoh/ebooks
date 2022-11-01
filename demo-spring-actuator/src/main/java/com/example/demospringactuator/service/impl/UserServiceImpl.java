package com.example.demospringactuator.service.impl;

import com.example.demospringactuator.domain.user.Users;
import com.example.demospringactuator.repo.UserRepository;
import com.example.demospringactuator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

}
