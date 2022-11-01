package com.example.demospringactuator.controller;


import com.example.demospringactuator.domain.user.Users;
import com.example.demospringactuator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<Users> save(@RequestBody Users user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

}
