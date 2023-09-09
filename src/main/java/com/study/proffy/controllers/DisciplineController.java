package com.study.proffy.controllers;

import com.study.proffy.entities.Discipline;
import com.study.proffy.services.DisciplineService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DisciplineController.BASE_URL)
public class DisciplineController {
    protected final static String BASE_URL = "/aulas";

    private final DisciplineService service;

    public DisciplineController(DisciplineService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSingle(@RequestBody Discipline discipline) {
        service.createSingle(discipline);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Discipline findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
