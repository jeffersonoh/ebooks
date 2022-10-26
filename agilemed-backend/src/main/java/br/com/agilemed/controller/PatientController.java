package br.com.agilemed.controller;

import br.com.agilemed.model.patient.Patient;
import br.com.agilemed.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService service;

    @Autowired
    PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Patient registerPatient(@RequestBody Patient obj) {
        return service.create(obj);
    }

    @PutMapping(value = "/cpf/{cpf}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Patient update(@PathVariable Long cpf, @RequestBody Patient obj) {
        return service.updatePatientByCPF(cpf, obj);
    }

    @DeleteMapping(value = "/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long cpf) {
        service.deletePatientByCPF(cpf);
    }

    @GetMapping(value = "/cpf/{cpf}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Patient findByCPF(@PathVariable Long cpf) {
        return service.findPatientByCPF(cpf);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findAll() {
        return service.findAll();
    }
}
