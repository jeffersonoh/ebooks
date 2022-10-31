package com.example.demospringjwt;

import com.example.demospringjwt.domain.user.Users;
import com.example.demospringjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoSpringJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringJwtApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveUser( new Users(null,"Joao","joao","123","ROLE_USER"));
            userService.saveUser( new Users(null,"José","jose","123","ROLE_ADMIN"));
        };
    }

}
