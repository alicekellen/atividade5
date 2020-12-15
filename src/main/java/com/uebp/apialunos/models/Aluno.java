package com.uebp.apialunos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno extends Usuario {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_curso")
	private long idCurso;

	public Aluno() {
	}

	public Aluno(long id, String name, long idCurso) {
		super(id, name);
		this.idCurso = idCurso;
	}

	public long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

}
