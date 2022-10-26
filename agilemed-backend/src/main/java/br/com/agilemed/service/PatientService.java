package br.com.agilemed.service;

import br.com.agilemed.model.patient.Patient;

import java.util.List;

public interface PatientService {

    Patient create(Patient obj);

    Patient updatePatientByCPF(Long cpf, Patient obj);

    void deletePatientByCPF(Long cpf);

    Patient findPatientByCPF(Long cpf);

    List<Patient> findAll();
}
