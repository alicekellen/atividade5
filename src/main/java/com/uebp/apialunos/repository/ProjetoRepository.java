package com.uebp.apialunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uebp.apialunos.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

	Projeto findById(long id);
}
