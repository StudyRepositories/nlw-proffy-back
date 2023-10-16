package com.study.proffy.mocks;

import com.study.proffy.entities.Teacher;

import java.util.Random;
import java.util.UUID;

public final class TeacherMock {

    private static final Random random = new Random();

    public static Teacher getSingle() {
        Teacher teacher =
                new Teacher().setId(random.nextLong(99) + 1).setResource(UUID.randomUUID()).setFirstname("Arnold")
                        .setLastname("Xuazineguer").setDescription("A big guy that make things happen")
                        .setProfilePicture("https://mock-image-url.com/arnold.png").setCellphone("12345678910");

        teacher.setEmail(teacher.getFirstname() + "." + teacher.getLastname() + "@email.com");
        return teacher;
    }
}
