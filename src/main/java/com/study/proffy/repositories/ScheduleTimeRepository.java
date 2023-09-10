package com.study.proffy.repositories;

import com.study.proffy.entities.ScheduleTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleTimeRepository extends JpaRepository<ScheduleTime, Long> {
}
