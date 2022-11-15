package com.study.proffy.services;

import com.study.proffy.builders.TeacherBuilder;
import com.study.proffy.entities.Teacher;
import com.study.proffy.repositories.TeacherRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceUnitTests {

    @Spy
    @InjectMocks
    private TeacherService service;

    @Mock
    private TeacherRepository repository;

    private static Teacher teacher;

    @BeforeAll
    public static void beforeAll() {
        teacher = TeacherBuilder.getBuilder()
                .withId(1L)
                .withName("John Doe")
                .withDescription("Lorem Ipsum Dolor Sit Amet")
                .build();
    }

    @Test
    @Order(1)
    public void shouldCreateTeacher() {
        doNothing().when(service).createSingle(Mockito.any(Teacher.class));

        service.createSingle(teacher);

        verify(service, times(1)).createSingle(teacher);
    }

    @Test
    @Order(2)
    public void shouldFindById() {
        when(service.findById(Mockito.any(Long.class))).thenReturn(teacher);

        Teacher returned = service.findById(1L);
        assertNotNull(returned);
    }
}
