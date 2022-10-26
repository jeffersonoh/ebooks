package br.com.agilemed.service.impl;

import br.com.agilemed.model.exam.Exam;
import br.com.agilemed.model.exam.ExamRepository;
import br.com.agilemed.model.patient.Patient;
import br.com.agilemed.model.patient.PatientRepository;
import br.com.agilemed.model.scheduling.Scheduling;
import br.com.agilemed.model.scheduling.SchedulingRepository;
import br.com.agilemed.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulingServiceImpl implements SchedulingService {

    private final SchedulingRepository schedulingRepository;

    private final PatientRepository patientRepositoryy;

    private final ExamRepository examRepository;

    @Autowired
    SchedulingServiceImpl(SchedulingRepository schedulingRepository, PatientRepository patientRepositoryy, ExamRepository examRepository) {
        this.schedulingRepository = schedulingRepository;
        this.patientRepositoryy = patientRepositoryy;
        this.examRepository = examRepository;
    }

    @Override
    public Scheduling create(Scheduling obj) {
        Patient patient = patientRepositoryy.getReferenceById(obj.getPatient().getId());
        obj.setPatient(patient);
        Exam exam = examRepository.getReferenceById(obj.getExam().getId());
        obj.setExam(exam);
        return schedulingRepository.save(obj);
    }

    @Override
    public Scheduling update(Long id, Scheduling obj) {
        Scheduling scheduling = schedulingRepository.getReferenceById(id);
        if (obj.getDate() != null) {
            scheduling.setDate(obj.getDate());
        }
        return schedulingRepository.save(scheduling);
    }

    @Override
    public void delete(Long id) {
        Scheduling scheduling = schedulingRepository.getReferenceById(id);
        if (scheduling != null) {
            schedulingRepository.delete(scheduling);
        } else
            throw new RuntimeException("Nao foi possivel remover o agendamento, agendamento nao encontrado");
    }

    @Override
    public List<Scheduling> findAll() {
        return schedulingRepository.findAll();
    }
}
