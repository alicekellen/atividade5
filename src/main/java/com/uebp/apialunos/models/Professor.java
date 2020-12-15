package com.uebp.apialunos.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PROFESSOR")
public class Professor extends Usuario {

	private static final long serialVersionUID = 1L;
	
	private String areaAtuacao;
	private String formacao;
	
	public Professor(long id, String name, String areaAtuacao, String formacao) {
		super();
		this.areaAtuacao = areaAtuacao;
		this.formacao = formacao;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	

	

		
}
