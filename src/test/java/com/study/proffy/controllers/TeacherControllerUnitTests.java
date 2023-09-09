package com.study.proffy.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.proffy.builders.TeacherBuilder;
import com.study.proffy.entities.Teacher;
import com.study.proffy.repositories.TeacherRepository;
import com.study.proffy.services.TeacherService;
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

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeacherControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private TeacherService service;

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
    public void shouldCallCreateTeacherRoute() throws Exception {
        doNothing().when(service).createSingle(Mockito.any(Teacher.class));

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .post(TeacherController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(mapper.writeValueAsBytes(teacher));

        mockMvc.perform(builder)
                .andExpect(status().is(HttpStatus.CREATED.value()));
    }

    @Test
    @Order(2)
    public void shouldCallFindTeacherByIdRoute() throws Exception {
        when(service.findById(Mockito.any(Long.class))).thenReturn(teacher);
        Teacher returned = service.findById(1L);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get(String.format("%s/%s", TeacherController.BASE_URL, 1L))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(StandardCharsets.UTF_8);

        MvcResult result = mockMvc.perform(builder)
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        Teacher teacher = mapper.readValue(result.getResponse().getContentAsString(), Teacher.class);
        assertNotNull(teacher);
    }
}
