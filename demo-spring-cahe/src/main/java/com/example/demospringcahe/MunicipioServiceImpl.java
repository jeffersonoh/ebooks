package com.example.demospringcahe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames={"municipios"})
public class MunicipioServiceImpl implements  MunicipioService{

    private final MunicipioRepo municipioRepo;

    @Autowired
    public MunicipioServiceImpl(MunicipioRepo municipioRepo) {
        this.municipioRepo = municipioRepo;
    }

    @Override
    public Municipio save(Municipio municipio) {
        return municipioRepo.save(municipio);
    }

    @Cacheable
    @Override
    public List<Municipio> getAll() {
        return municipioRepo.findAll();
    }
}
