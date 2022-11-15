package com.study.proffy.services;

import com.study.proffy.entities.Teacher;
import com.study.proffy.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public void createSingle(Teacher teacher) {
        repository.save(teacher);
    }

    public Teacher findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
