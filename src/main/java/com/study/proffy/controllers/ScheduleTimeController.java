package com.study.proffy.controllers;

import com.study.proffy.entities.ScheduleTime;
import com.study.proffy.entities.Teacher;
import com.study.proffy.services.ScheduleTimeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ScheduleTimeController.BASE_URL)
public class ScheduleTimeController {

    protected final static String BASE_URL = "/horarios";
    private final ScheduleTimeService service;

    public ScheduleTimeController(ScheduleTimeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSingle(@RequestBody ScheduleTime scheduleTime) {
        service.createSingle(scheduleTime);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ScheduleTime findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
