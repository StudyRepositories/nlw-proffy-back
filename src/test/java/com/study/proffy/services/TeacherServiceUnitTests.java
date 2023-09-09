package com.study.proffy.services;

import com.study.proffy.builders.TeacherBuilder;
import com.study.proffy.entities.Teacher;
import com.study.proffy.repositories.TeacherRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        when(repository.save(Mockito.any(Teacher.class))).thenReturn(teacher);
        service.createSingle(teacher);
        verify(service, times(1)).createSingle(teacher);
    }

    @Test
    @Order(2)
    public void shouldFindById() {
        when(repository.findById(Mockito.any(Long.class))).thenReturn(Optional.ofNullable(teacher));

        Teacher returned = service.findById(1L);
        assertNotNull(returned);
    }
}
