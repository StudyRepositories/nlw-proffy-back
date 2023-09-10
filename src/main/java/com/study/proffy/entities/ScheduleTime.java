package com.study.proffy.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = ScheduleTime.TABLE_NAME)
public class ScheduleTime {

    public static final String TABLE_NAME = "AULA_HORARIO";
    public static final String SEQUENCE_NAME = "SEQ_AUHO_SQ_AULA_HORARIO";
    private static final String COLUMN_ID = "AUHO_SQ_AULA_HORARIO";
    private static final String COLUMN_WEEKDAY = "AUHO_NU_DIA_DA_SEMANA";
    private static final String COLUMN_START_TIME = "AUHO_HR_INICIO";
    private static final String COLUMN_END_TIME = "AUHO_HR_FIM";
    private static final String COLUMN_AULA_ID = "AULA_SQ_AULA";

    @Id
    @Column(name = COLUMN_ID, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQUENCE_NAME)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = COLUMN_WEEKDAY)
    private DayOfWeek dayOfWeek;

    @Column(name = COLUMN_START_TIME)
    private LocalTime start;

    @Column(name = COLUMN_END_TIME)
    private LocalTime end;

    @ManyToOne
    @JoinColumn(name = COLUMN_AULA_ID)
    private Discipline discipline;

    public ScheduleTime() {
    }

    public ScheduleTime(Long id, DayOfWeek dayOfWeek, LocalTime start, LocalTime end, Discipline discipline) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.start = start;
        this.end = end;
        this.discipline = discipline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek weekday) {
        this.dayOfWeek = weekday;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
