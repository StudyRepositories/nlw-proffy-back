package com.study.proffy.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.proffy.entities.Teacher;
import com.study.proffy.mocks.TeacherMock;
import com.study.proffy.services.simple.SimpleTeacherService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(TeacherController.class)
@ExtendWith(MockitoExtension.class)
public class TeacherControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean(name = "simpleTeacherService")
    private SimpleTeacherService service;

    private static Teacher teacher;
    private static ObjectMapper mapper;

    @BeforeAll
    public static void beforeAll() {
        teacher = TeacherMock.getSingle();
        mapper = new ObjectMapper();
    }

    @Test
    public void should_Create_Single() throws Exception {
        when(service.createSingle(any(Teacher.class))).thenReturn(teacher);

        RequestBuilder requestBuilder = post(TeacherController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(mapper.writeValueAsString(teacher));

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().is(HttpStatus.CREATED.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Teacher actual = mapper.readValue(result.getResponse().getContentAsString(), Teacher.class);

        assertNotNull(actual);
        assertEquals(teacher, actual);
    }

    @Test
    public void should_Find_By_Resource() throws Exception {
        final String url = TeacherController.BASE_URL + "/" + UUID.randomUUID();

        when(service.findByResource(any(UUID.class))).thenReturn(teacher);

        RequestBuilder requestBuilder = get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Teacher actual = mapper.readValue(result.getResponse().getContentAsString(), Teacher.class);

        assertNotNull(actual);
        assertEquals(teacher, actual);
    }

    @Test
    public void should_Update_By_Resource() throws Exception {
        final String url = TeacherController.BASE_URL + "/" + UUID.randomUUID();

        doNothing().when(service).updateByResource(any(UUID.class), any(Teacher.class));

        RequestBuilder requestBuilder = put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(mapper.writeValueAsString(teacher));

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(HttpStatus.ACCEPTED.value()));
    }

    @Test
    public void should_Delete_By_Resource() throws Exception {
        final String url = TeacherController.BASE_URL + "/" + UUID.randomUUID();

        doNothing().when(service).deleteByResource(any(UUID.class));

        RequestBuilder requestBuilder = delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(HttpStatus.ACCEPTED.value()));
    }
}
