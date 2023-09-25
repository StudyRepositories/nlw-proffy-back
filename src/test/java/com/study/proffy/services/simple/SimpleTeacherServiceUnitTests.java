package com.study.proffy.services.simple;

import com.study.proffy.entities.Teacher;
import com.study.proffy.mocks.TeacherMock;
import com.study.proffy.repositories.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SimpleTeacherServiceUnitTests {

    @Spy
    @InjectMocks
    private SimpleTeacherService service;

    @Mock
    private TeacherRepository repository;

    @Test
    public void should_Create_Single() {
        Teacher expected = TeacherMock.getSingle();

        when(repository.save(any(Teacher.class))).thenReturn(expected);

        Teacher actual = service.createSingle(expected);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void should_Find_By_Resource() {
        Teacher expected = TeacherMock.getSingle()
                .setId(1L)
                .setResource(UUID.randomUUID());

        when(repository.findByResource(any(UUID.class))).thenReturn(expected);

        Teacher actual = service.findByResource(expected.getResource());

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void should_Update_By_Resource() {
        Teacher old = TeacherMock.getSingle()
                .setId(1L)
                .setResource(UUID.randomUUID());

        Teacher changed = TeacherMock.getSingle()
                .setId(1L)
                .setResource(old.getResource())
                .setLastname("Schwarzenegger");

        when(repository.findByResource(any(UUID.class))).thenReturn(old);

        service.updateByResource(old.getResource(), changed);

        verify(service, times(1)).updateByResource(old.getResource(), changed);
    }

    @Test
    public void should_Delete_By_Resource() {
        Teacher expected = TeacherMock.getSingle()
                .setId(1L)
                .setResource(UUID.randomUUID());

        service.deleteByResource(expected.getResource());

        verify(service, times(1)).deleteByResource(expected.getResource());
    }
}
