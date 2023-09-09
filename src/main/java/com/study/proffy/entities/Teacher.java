package com.study.proffy.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = Teacher.TABLE_NAME)
public class Teacher {

    public static final String TABLE_NAME = "PROFESSOR";
    public static final String SEQUENCE_NAME = "SEQ_PROF_SQ_PROFESSOR";
    public static final String COLUMN_ID = "PROF_SQ_PROFESSOR";
    public static final String COLUMN_NAME = "PROF_NM_COMPLETO";
    public static final String COLUMN_DESCRIPTION = "PROF_DS_PROFESSOR";
    public static final String COLUMN_AVATAR = "PROF_IM_AVATAR";
    public static final String COLUMN_PHONE_NUMBER = "PROF_NM_CELULAR";

    @Id
    @Column(name = COLUMN_ID, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQUENCE_NAME)
    private Long id;

    @Column(name = COLUMN_NAME, nullable = false)
    private String name;

    @Column(name = COLUMN_AVATAR)
    private Byte[] avatar;

    @Column(name = COLUMN_PHONE_NUMBER, unique = true)
    private String phoneNumber;

    @Column(name = COLUMN_DESCRIPTION)
    private String description;
    
    @OneToMany(mappedBy = "teacher")
    private List<Discipline> classes;

    public Teacher() {

    }

    public Teacher(Long id, String name, Byte[] avatar, String phoneNumber, String description) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(Byte[] avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
