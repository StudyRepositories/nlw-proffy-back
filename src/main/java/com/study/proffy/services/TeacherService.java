package com.study.proffy.services;

import com.study.proffy.entities.Teacher;

import java.util.UUID;

public interface TeacherService {

    Teacher createSingle(Teacher teacher);

    Teacher findByResource(UUID resource);

    void updateByResource(UUID resource, Teacher changed);

    void deleteByResource(UUID resource);
}
