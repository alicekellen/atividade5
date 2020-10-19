package com.uebp.apialunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uebp.apialunos.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findById(long id);
}
