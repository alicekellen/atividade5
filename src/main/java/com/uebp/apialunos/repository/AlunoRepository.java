package com.uebp.apialunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uebp.apialunos.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	Aluno findById(long id);
}
