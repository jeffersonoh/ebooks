package br.com.agilemed.service.impl;

import br.com.agilemed.model.exam.Exam;
import br.com.agilemed.model.exam.ExamRepository;
import br.com.agilemed.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    private final ExamRepository repository;

    @Autowired
    ExamServiceImpl(ExamRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Exam> findAll() {
        return repository.findAll();
    }
}
