package com.study.proffy.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.proffy.builders.DisciplineBuilder;
import com.study.proffy.entities.Discipline;
import com.study.proffy.entities.Teacher;
import com.study.proffy.services.DisciplineService;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DisciplineControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private DisciplineService service;

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
    public void shouldCallCreateSingleRoute() throws Exception {
        doNothing().when(service).createSingle(discipline);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .post(DisciplineController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(mapper.writeValueAsBytes(discipline));

        mockMvc.perform(builder)
                .andExpect(status().is(HttpStatus.CREATED.value()));
    }
    @Test
    @Order(2)
    public void shouldCallFindByIdRoute() throws Exception {
        when(service.findById(Mockito.any(Long.class))).thenReturn(discipline);
        Discipline returned = service.findById(1L);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get(String.format("%s/%s", DisciplineController.BASE_URL, 1L))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(StandardCharsets.UTF_8);

        MvcResult result = mockMvc.perform(builder)
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        Discipline discipline = mapper.readValue(result.getResponse().getContentAsString(), Discipline.class);
        assertNotNull(discipline);
    }

}
