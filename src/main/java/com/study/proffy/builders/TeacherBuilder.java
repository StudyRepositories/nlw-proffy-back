package com.study.proffy.builders;

import com.study.proffy.entities.Teacher;

/**
 * @author caiom
 * Classe utilizada para a construção de entidades do tipo {@link Teacher}
 */
public class TeacherBuilder {

    /**
     * Entidade {@link Teacher} que será retornada pela função build
     */
    private final Teacher teacher;

    private TeacherBuilder() {
        this.teacher = new Teacher();
    }

    public static TeacherBuilder getBuilder() {
        return new TeacherBuilder();
    }

    /**
     * Aplica um novo valor para a 'id' da entidade
     * @param id Valor que será atribuído para o campo 'id'
     *           da entidade {@link Teacher} instanciada pelo construtor.
     * @return O próprio {@link TeacherBuilder}
     */
    public TeacherBuilder withId(Long id) {
        teacher.setId(id);
        return this;
    }

    /**
     * Aplica um novo valor para a 'name' da entidade
     * @param name Valor que será atribuído para o campo 'name'
     *             da entidade {@link Teacher} instanciada pelo construtor.
     * @return O próprio {@link TeacherBuilder}
     */
    public TeacherBuilder withName(String name) {
        teacher.setName(name);
        return this;
    }

    /**
     * Aplica um novo valor para a 'avatar' da entidade
     * @param avatar Valor que será atribuído para o campo 'avatar'
     *               da entidade {@link Teacher} instanciada pelo construtor.
     * @return O próprio {@link TeacherBuilder}
     */
    public TeacherBuilder withAvatar(byte[] avatar) {
        teacher.setAvatar(avatar);
        return this;
    }

    /**
     * Aplica um novo valor para a 'phoneNumber' da entidade
     * @param phoneNumber Valor que será atribuído para o campo 'phoneNumber'
     *                    da entidade {@link Teacher} instanciada pelo construtor.
     * @return O próprio {@link TeacherBuilder}
     */
    public TeacherBuilder withCellphone(String phoneNumber) {
        teacher.setPhoneNumber(phoneNumber);
        return this;
    }

    /**
     * Aplica um novo valor para a 'descrição' da entidade
     * @param description Valor que será atribuído para o campo 'descrição'
     *                    da entidade {@link Teacher} instanciada pelo construtor.
     * @return O próprio {@link TeacherBuilder}
     */
    public TeacherBuilder withDescription(String description) {
        teacher.setDescription(description);
        return this;
    }

    /**
     * Constrói o objeto do tipo {@link Teacher}
     * @return Entidade {@link Teacher} instanciada pelo construtor do builder
     * com os parâmetros passados pelas funções with
     */
    public Teacher build() {
        return teacher;
    }
}
