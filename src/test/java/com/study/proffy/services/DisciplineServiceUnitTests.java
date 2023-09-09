package com.study.proffy.services;

import com.study.proffy.builders.DisciplineBuilder;
import com.study.proffy.entities.Discipline;
import com.study.proffy.entities.Teacher;
import com.study.proffy.repositories.DisciplineRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DisciplineServiceUnitTests {

    @Spy
    @InjectMocks
    private DisciplineService service;

    @Mock
    private DisciplineRepository repository;
    private static Discipline discipline;


    @BeforeAll
    public static void beforeAll() {
        discipline = DisciplineBuilder.getBuilder()
                .withId(1L)
                .withName("Matemática")
                .withPrice(new BigDecimal("150.00"))
                .withTeacher(new Teacher())
                .build();
    }

    @Test
    @Order(1)
    public void shouldCreateDiscipline() {
        when(repository.save(any(Discipline.class))).thenReturn(discipline);
        service.createSingle(discipline);
        verify(service, times(1)).createSingle(discipline);
    }

    @Test
    @Order(2)
    public void shouldFindById() {
        when(repository.findById(any(Long.class))).thenReturn(Optional.ofNullable(discipline));
        Discipline returned = service.findById(1L);

        assertNotNull(returned);
        assertEquals(discipline, returned);
    }
}
