package br.com.agilemed.controller;

import br.com.agilemed.model.scheduling.Scheduling;
import br.com.agilemed.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {
    private final SchedulingService service;

    @Autowired
    SchedulingController(SchedulingService service) {
        this.service = service;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Scheduling registerPatient(@RequestBody Scheduling obj) {
        return service.create(obj);
    }

    @PutMapping(value = "/id/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Scheduling update(@PathVariable Long id, @RequestBody Scheduling obj) {
        return service.update(id, obj);
    }

    @DeleteMapping(value = "/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Scheduling> findAll() {
        return service.findAll();
    }
}
