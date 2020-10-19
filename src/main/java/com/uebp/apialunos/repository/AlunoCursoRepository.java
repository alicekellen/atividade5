package com.uebp.apialunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uebp.apialunos.models.AlunoCurso;

public interface AlunoCursoRepository extends JpaRepository<AlunoCurso, Long> {
	
	AlunoCurso findById(long id);

}
