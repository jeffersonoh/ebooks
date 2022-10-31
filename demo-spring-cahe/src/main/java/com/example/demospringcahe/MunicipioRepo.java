package com.example.demospringcahe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepo extends JpaRepository<Municipio, Long> {
}
