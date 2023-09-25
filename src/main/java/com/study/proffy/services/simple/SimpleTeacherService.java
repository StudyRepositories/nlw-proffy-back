package com.study.proffy.services.simple;

import com.study.proffy.entities.Teacher;
import com.study.proffy.repositories.TeacherRepository;
import com.study.proffy.services.TeacherService;
import jakarta.persistence.TupleElement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SimpleTeacherService implements TeacherService {

    private final TeacherRepository repository;

    public SimpleTeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Teacher createSingle(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Teacher findByResource(UUID resource) {
        return repository.findByResource(resource);
    }

    @Override
    @Transactional
    public void updateByResource(UUID resource, Teacher teacher) {
        Teacher persisted = repository.findByResource(resource);
        teacher.setId(persisted.getId());
        teacher.setResource(resource);
        repository.save(teacher);
    }

    @Override
    @Transactional
    public void deleteByResource(UUID resource) {
        repository.deleteByResource(resource);
    }

}
