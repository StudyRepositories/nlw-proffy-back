package com.study.proffy.builders;

import com.study.proffy.entities.Discipline;
import com.study.proffy.entities.ScheduleTime;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * @author caiom
 * Classe utilizada para a construção de entidades do tipo {@link ScheduleTime}
 */
public class ScheduleTimeBuilder {

    /**
     * Entidade {@link ScheduleTime} que será retornada pela função build
     */
    private final ScheduleTime scheduleTime;

    private ScheduleTimeBuilder() {
        this.scheduleTime = new ScheduleTime();
    }

    public static ScheduleTimeBuilder getBuilder() {
        return new ScheduleTimeBuilder();
    }

    /**
     * Aplica um novo valor para a 'id' da entidade
     * @param id Valor que será atribuído para o campo 'id'
     *           da entidade {@link ScheduleTime} instanciada pelo construtor.
     * @return O próprio {@link ScheduleTimeBuilder}
     */
    public ScheduleTimeBuilder withId(Long id) {
        scheduleTime.setId(id);
        return this;
    }

    /**
     * Aplica um novo valor para a 'dayOfWeek' da entidade
     * @param dayOfWeek Valor que será atribuído para o campo 'dayOfWeek'
     *             da entidade {@link ScheduleTime} instanciada pelo construtor.
     * @return O próprio {@link ScheduleTimeBuilder}
     */
    public ScheduleTimeBuilder withDayOfWeek(DayOfWeek dayOfWeek) {
        scheduleTime.setDayOfWeek(dayOfWeek);
        return this;
    }

    /**
     * Aplica um novo valor para a 'start' da entidade
     * @param start Valor que será atribuído para o campo 'start'
     *               da entidade {@link ScheduleTime} instanciada pelo construtor.
     * @return O próprio {@link ScheduleTimeBuilder}
     */
    public ScheduleTimeBuilder withStart(LocalTime start) {
        scheduleTime.setStart(start);
        return this;
    }

    /**
     * Aplica um novo valor para a 'end' da entidade
     * @param end Valor que será atribuído para o campo 'end'
     *               da entidade {@link ScheduleTime} instanciada pelo construtor.
     * @return O próprio {@link ScheduleTimeBuilder}
     */
    public ScheduleTimeBuilder withEnd(LocalTime end) {
        scheduleTime.setEnd(end);
        return this;
    }

    /**
     * Aplica um novo valor para a 'discipline' da entidade
     * @param discipline Valor que será atribuído para o campo 'discipline'
     *                    da entidade {@link ScheduleTime} instanciada pelo construtor.
     * @return O próprio {@link ScheduleTimeBuilder}
     */
    public ScheduleTimeBuilder withDiscipline(Discipline discipline) {
        scheduleTime.setDiscipline(discipline);
        return this;
    }

    /**
     * Constrói o objeto do tipo {@link ScheduleTime}
     * @return Entidade {@link ScheduleTime} instanciada pelo construtor do builder
     * com os parâmetros passados pelas funções with
     */
    public ScheduleTime build() {
        return scheduleTime;
    }
}
