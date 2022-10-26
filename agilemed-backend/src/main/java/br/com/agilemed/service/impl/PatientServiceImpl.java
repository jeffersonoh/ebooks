package br.com.agilemed.service.impl;

import br.com.agilemed.model.patient.Patient;
import br.com.agilemed.model.patient.PatientRepository;
import br.com.agilemed.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    @Autowired
    PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Patient create(Patient obj) {
        return repository.save(obj);
    }

    @Override
    public Patient updatePatientByCPF(Long cpf, Patient newObj) {
        Patient byCpf = repository.findByCpf(cpf);
        if (byCpf != null) {
            if (newObj.getName() != null) {
                byCpf.setName(newObj.getName());
            }
            if (newObj.getBirthYear() != null) {
                byCpf.setBirthYear(newObj.getBirthYear());
            }
            return repository.save(byCpf);
        }
        throw new RuntimeException("Nao foi possivel atualizar o paciente, CPF nao encontrado");
    }

    @Override
    public void deletePatientByCPF(Long cpf) {
        Patient byCpf = repository.findByCpf(cpf);
        if (byCpf != null) {
            repository.delete(byCpf);
        } else
            throw new RuntimeException("Nao foi possivel remover o paciente, CPF nao encontrado");
    }

    @Override
    public Patient findPatientByCPF(Long cpf) {
        return repository.findByCpf(cpf);
    }

    @Override
    public List<Patient> findAll() {
        return repository.findAll();
    }
}
