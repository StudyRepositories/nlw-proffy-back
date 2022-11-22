package com.study.proffy.builders;

import com.study.proffy.entities.Discipline;
import com.study.proffy.entities.Teacher;

/**
 * @author caiom
 * Classe utilizada para a construção de entidades do tipo {@link Discipline}
 */
public class DisciplineBuilder {

    /**
     * Entidade {@link Discipline} que será retornada pela função build
     */
    private final Discipline discipline;

    private DisciplineBuilder() {
        this.discipline = new Discipline();
    }

    public static DisciplineBuilder getBuilder() {
        return new DisciplineBuilder();
    }

    /**
     * Aplica um novo valor para a 'id' da entidade
     * @param id Valor que será atribuído para o campo 'id'
     *           da entidade {@link Discipline} instanciada pelo construtor.
     * @return O próprio {@link DisciplineBuilder}
     */
    public DisciplineBuilder withId(Long id) {
        discipline.setId(id);
        return this;
    }

    /**
     * Aplica um novo valor para a 'name' da entidade
     * @param name Valor que será atribuído para o campo 'name'
     *             da entidade {@link Discipline} instanciada pelo construtor.
     * @return O próprio {@link DisciplineBuilder}
     */
    public DisciplineBuilder withName(String name) {
        discipline.setName(name);
        return this;
    }

    /**
     * Aplica um novo valor para a 'price' da entidade
     * @param price Valor que será atribuído para o campo 'price'
     *               da entidade {@link Discipline} instanciada pelo construtor.
     * @param price 
     * @return O próprio {@link DisciplineBuilder}
     */
    public DisciplineBuilder withPrice(Number price) {
        discipline.setPrice(price);
        return this;
    }

    /**
     * Aplica um novo valor para a 'teacher' da entidade
     * @param teacher Valor que será atribuído para o campo 'teacher'
     *                    da entidade {@link Discipline} instanciada pelo construtor.
     * @return O próprio {@link DisciplineBuilder}
     */
    public DisciplineBuilder withTeacher(Teacher teacher) {
        discipline.setTeacher(teacher);
        return this;
    }

    /**
     * Constrói o objeto do tipo {@link Discipline}
     * @return Entidade {@link Discipline} instanciada pelo construtor do builder
     * com os parâmetros passados pelas funções with
     */
    public Discipline build() {
        return discipline;
    }
}
