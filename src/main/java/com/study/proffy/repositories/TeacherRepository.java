package com.study.proffy.repositories;

import com.study.proffy.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByResource(UUID resource);

    void deleteByResource(UUID resource);
}
