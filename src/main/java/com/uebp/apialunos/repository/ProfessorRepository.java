package com.uebp.apialunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uebp.apialunos.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	Professor findById(long id);
}
