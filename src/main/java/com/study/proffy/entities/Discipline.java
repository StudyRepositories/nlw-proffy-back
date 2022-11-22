package com.study.proffy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = Discipline.TABLE_NAME)
public class Discipline {

	public static final String TABLE_NAME = "AULA";
	private static final String COLUMN_ID = "AULA_SQ_AULA";
	private static final String AULA_NM_MATERIA = "AULA_NM_MATERIA";
	private static final String AULA_VL_CUSTO = "AULA_VL_CUSTO";
	private static final String PROF_SQ_PROFESSOR = "PROF_SQ_PROFESSOR";
	
	@Id
    @Column(name = COLUMN_ID)
	private Long id;
	
	@Column(name = AULA_NM_MATERIA)
	private String name;
	
	@Column(name = AULA_VL_CUSTO)
	private Number price;
	
	@ManyToOne
	@JoinColumn(name = PROF_SQ_PROFESSOR)
	private Teacher teacher;
	
	public Discipline() {
		
	}

	public Discipline(Long id, String name, Number price, Teacher teacher) {
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

	public Number getPrice() {
		return price;
	}

	public void setPrice(Number price) {
		this.price = price;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}	
}
