package com.study.proffy.exceptions.teacher;

import com.study.proffy.entities.Teacher;

public final class TeacherEmailAlreadyInUseException extends TeacherException {

    public TeacherEmailAlreadyInUseException(Teacher teacher) {
        super(teacher);
    }
}
