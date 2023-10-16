package com.study.proffy.exceptions.teacher;

import com.study.proffy.entities.Teacher;

public sealed class TeacherException extends RuntimeException permits TeacherEmailAlreadyInUseException, TeacherNotFoundException {

    private final Teacher teacher;

    public TeacherException(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
