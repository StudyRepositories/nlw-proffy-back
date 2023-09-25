package com.study.proffy.controllers;

import com.study.proffy.entities.Teacher;
import com.study.proffy.services.TeacherService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(TeacherController.BASE_URL)
public class TeacherController {

    public static final String BASE_URL = "/teachers";

    private final TeacherService service;

    public TeacherController(@Qualifier("simpleTeacherService") TeacherService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher createSingle(@RequestBody Teacher teacher) {
        return service.createSingle(teacher);
    }

    @GetMapping("/{resource}")
    @ResponseStatus(HttpStatus.FOUND)
    public Teacher findByResource(@PathVariable UUID resource) {
        return service.findByResource(resource);
    }

    @PutMapping("/{resource}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateByResource(@PathVariable UUID resource, @RequestBody Teacher changed) {
        service.updateByResource(resource, changed);
    }

    @DeleteMapping("/{resource}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteByResource(@PathVariable UUID resource) {
        service.deleteByResource(resource);
    }
}
