package com.example.demospringcahe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    private final MunicipioService service;

    @Autowired
    public MunicipioController(MunicipioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Municipio>> findAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Municipio> save(@RequestBody Municipio municipio) {
        return ResponseEntity.ok().body(service.save(municipio));
    }
}
