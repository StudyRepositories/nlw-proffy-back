package com.study.proffy.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.proffy.builders.DisciplineBuilder;
import com.study.proffy.builders.ScheduleTimeBuilder;
import com.study.proffy.entities.Discipline;
import com.study.proffy.entities.ScheduleTime;
import com.study.proffy.entities.Teacher;
import com.study.proffy.services.ScheduleTimeService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScheduleTimeControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private ScheduleTimeService service;

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
    public void shouldCallCreateSingleRoute() throws Exception {
        doNothing().when(service).createSingle(scheduleTime);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .post(ScheduleTimeController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(mapper.writeValueAsBytes(scheduleTime));

        mockMvc.perform(builder)
                .andExpect(status().is(HttpStatus.CREATED.value()));
    }

    @Test
    @Order(2)
    public void shouldCallFindByIdRoute() throws Exception {
        when(service.findById(Mockito.any(Long.class))).thenReturn(scheduleTime);
        ScheduleTime returned = service.findById(1L);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get(String.format("%s/%s", ScheduleTimeController.BASE_URL, 1L))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(StandardCharsets.UTF_8);

        MvcResult result = mockMvc.perform(builder)
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        ScheduleTime scheduleTime = mapper.readValue(result.getResponse().getContentAsString(), ScheduleTime.class);
        assertNotNull(scheduleTime);
    }

}
