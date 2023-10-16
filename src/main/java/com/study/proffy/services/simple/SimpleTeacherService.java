package com.study.proffy.services.simple;

import com.study.proffy.entities.Teacher;
import com.study.proffy.exceptions.teacher.TeacherEmailAlreadyInUseException;
import com.study.proffy.exceptions.teacher.TeacherNotFoundException;
import com.study.proffy.repositories.TeacherRepository;
import com.study.proffy.services.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class SimpleTeacherService implements TeacherService {

    private final TeacherRepository repository;

    public SimpleTeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Teacher createSingle(Teacher teacher) {
        Optional<Teacher> optTeacher = repository.findByEmail(teacher.getEmail());
        optTeacher.ifPresent((value) -> {
            throw new TeacherEmailAlreadyInUseException(value);
        });
        return repository.save(teacher);
    }

    @Override
    public Teacher findByResource(UUID resource) {
        Optional<Teacher> optionalTeacher = repository.findByResource(resource);
        if (optionalTeacher.isEmpty()) {
            throw new TeacherNotFoundException();
        }
        return optionalTeacher.get();
    }

    @Override
    @Transactional
    public void updateByResource(UUID resource, Teacher teacher) {
        Teacher persisted = findByResource(resource);
        teacher.setId(persisted.getId());
        teacher.setResource(resource);
        repository.save(teacher);
    }

    @Override
    @Transactional
    public void deleteByResource(UUID resource) {
        findByResource(resource);
        repository.deleteByResource(resource);
    }

}
