package com.example.demospringcahe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringCaheApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCaheApplication.class, args);
    }

    @Bean
    CommandLineRunner run(MunicipioService municipioService) {
        return args -> {
            municipioService.save(new Municipio(null, "SC", "ABELARDO LUZ"));
            municipioService.save(new Municipio(null, "SC", "AGRONÔMICA"));
            municipioService.save(new Municipio(null, "SC", "ÁGUAS MORNAS"));
            municipioService.save(new Municipio(null, "SC", "ALFREDO WAGNER"));
            municipioService.save(new Municipio(null, "SC", "ANGELINA"));
            municipioService.save(new Municipio(null, "SC", "ANITA GARIBALDI"));
        };
    }

}
