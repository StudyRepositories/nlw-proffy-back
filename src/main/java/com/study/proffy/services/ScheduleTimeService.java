package com.study.proffy.services;

import com.study.proffy.entities.ScheduleTime;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTimeService {

    private final ScheduleTimeRepository repository;

    public ScheduleTimeService(ScheduleTimeRepository repository) {
        this.repository = repository;
    }

    public void createSingle(ScheduleTime scheduleTime) {
        repository.save(scheduleTime);
    }

    public ScheduleTime findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
