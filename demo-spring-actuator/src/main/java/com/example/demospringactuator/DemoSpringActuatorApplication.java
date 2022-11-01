package com.example.demospringactuator;

import com.example.demospringactuator.domain.user.Users;
import com.example.demospringactuator.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringActuatorApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveUser( new Users(null,"Joao","joao","123","ROLE_USER"));
			userService.saveUser( new Users(null,"José","jose","123","ROLE_ADMIN"));
		};
	}
}
