package br.com.agilemed.service;

import br.com.agilemed.model.exam.Exam;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ExamService {
    List<Exam> findAll();
}
