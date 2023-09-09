package com.study.proffy.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = Discipline.TABLE_NAME)
public class Discipline {

    public static final String TABLE_NAME = "AULA";
    public static final String SEQUENCE_NAME = "SEQ_AULA_SQ_AULA";
    private static final String COLUMN_ID = "AULA_SQ_AULA";
    private static final String COLUMN_NAME = "AULA_NM_MATERIA";
    private static final String COLUMN_PRICE = "AULA_VL_CUSTO";
    private static final String COLUMN_PROF_ID = "PROF_SQ_PROFESSOR";

    @Id
    @Column(name = COLUMN_ID, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQUENCE_NAME)
    private Long id;

    @Column(name = COLUMN_NAME)
    private String name;

    @Column(name = COLUMN_PRICE)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = COLUMN_PROF_ID)
    private Teacher teacher;

    public Discipline() {

    }

    public Discipline(Long id, String name, BigDecimal price, Teacher teacher) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.teacher = teacher;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
