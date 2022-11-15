package com.study.proffy.controllers;

import com.study.proffy.entities.Teacher;
import com.study.proffy.services.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = TeacherController.BASE_URL)
public class TeacherController {
    protected final static String BASE_URL = "/professores";

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSingle(@RequestBody Teacher teacher) {
        service.createSingle(teacher);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Teacher findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
