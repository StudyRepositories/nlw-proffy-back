package com.study.proffy.services;

import com.study.proffy.builders.ScheduleTimeBuilder;
import com.study.proffy.entities.Discipline;
import com.study.proffy.entities.ScheduleTime;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScheduleTimeServiceUnitTests {

    @Spy
    @InjectMocks
    private ScheduleTimeService service;

    @Mock
    private ScheduleTimeRepository repository;
    private static ScheduleTime scheduleTime;

    @BeforeAll
    public static void beforeAll() {
        scheduleTime = ScheduleTimeBuilder.getBuilder()
                .withId(1L)
                .withDayOfWeek(DayOfWeek.MONDAY)
                .withStart(LocalTime.of(13, 0, 0))
                .withEnd(LocalTime.of(15, 0, 0))
                .withDiscipline(new Discipline())
                .build();
    }

    @Test
    @Order(1)
    public void shouldCreateDiscipline() {
        when(repository.save(any(ScheduleTime.class))).thenReturn(scheduleTime);
        service.createSingle(scheduleTime);
        verify(service, times(1)).createSingle(scheduleTime);
    }

    @Test
    @Order(2)
    public void shouldFindById() {
        when(repository.findById(any(Long.class))).thenReturn(Optional.ofNullable(scheduleTime));
        ScheduleTime returned = service.findById(1L);

        assertNotNull(returned);
        assertEquals(scheduleTime, returned);
    }
}
