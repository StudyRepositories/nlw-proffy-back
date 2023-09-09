package com.study.proffy.services;

import com.study.proffy.entities.Discipline;
import com.study.proffy.repositories.DisciplineRepository;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService {

    private final DisciplineRepository repository;

    public DisciplineService(DisciplineRepository repository) {
        this.repository = repository;
    }

    public void createSingle(Discipline discipline) {
        repository.save(discipline);
    }

    public Discipline findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
