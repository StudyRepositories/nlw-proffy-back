package com.study.proffy.services.simple;

import com.study.proffy.entities.Teacher;
import com.study.proffy.exceptions.teacher.TeacherEmailAlreadyInUseException;
import com.study.proffy.exceptions.teacher.TeacherException;
import com.study.proffy.exceptions.teacher.TeacherNotFoundException;
import com.study.proffy.mocks.TeacherMock;
import com.study.proffy.repositories.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
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

        when(repository.findByResource(any(UUID.class))).thenReturn(Optional.ofNullable(expected));

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

        when(repository.findByResource(any(UUID.class))).thenReturn(Optional.of(old));

        service.updateByResource(old.getResource(), changed);

        verify(service, times(1)).updateByResource(old.getResource(), changed);
    }

    @Test
    public void should_Delete_By_Resource() {
        Teacher expected = TeacherMock.getSingle()
                .setId(1L)
                .setResource(UUID.randomUUID());

        when(repository.findByResource(any(UUID.class))).thenReturn(Optional.ofNullable(expected));
        service.deleteByResource(expected.getResource());

        verify(service, times(1)).deleteByResource(expected.getResource());
    }

    @Test
    public void should_Throw_Email_Already_In_Use_Exception() {
        Teacher teacher = TeacherMock.getSingle();
        when(repository.findByEmail(anyString())).thenReturn(Optional.ofNullable(teacher));
        Throwable throwable = assertThrows(TeacherException.class, () -> {
            Teacher saved = service.createSingle(teacher);
        });

        assertEquals(TeacherEmailAlreadyInUseException.class, throwable.getClass());
    }

    @Test
    public void should_Throw_Not_Found_Exception_Find_By_Resource() {
        when(repository.findByResource(any(UUID.class))).thenReturn(Optional.empty());
        Throwable throwable = assertThrows(TeacherException.class, () -> {
            Teacher found = service.findByResource(UUID.randomUUID());
        });

        assertEquals(TeacherNotFoundException.class, throwable.getClass());
    }

    @Test
    public void should_Throw_Not_Found_Exception_Update_By_Resource() {
        when(repository.findByResource(any(UUID.class))).thenReturn(Optional.empty());
        Throwable throwable = assertThrows(TeacherException.class, () -> {
            service.updateByResource(UUID.randomUUID(), TeacherMock.getSingle());
        });

        assertEquals(TeacherNotFoundException.class, throwable.getClass());
    }

    @Test
    public void should_Throw_Not_Found_Exception_Delete_By_Resource() {
        when(repository.findByResource(any(UUID.class))).thenReturn(Optional.empty());
        Throwable throwable = assertThrows(TeacherException.class, () -> {
            service.deleteByResource(UUID.randomUUID());
        });

        assertEquals(TeacherNotFoundException.class, throwable.getClass());
    }
}
