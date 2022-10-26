package br.com.agilemed.service;

import br.com.agilemed.model.scheduling.Scheduling;

import java.util.List;

public interface SchedulingService {

    Scheduling create(Scheduling obj);

    Scheduling update(Long id,Scheduling obj);

    void delete(Long id);

    List<Scheduling> findAll();
}
