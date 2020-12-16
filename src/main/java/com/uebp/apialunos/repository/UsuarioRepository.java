package com.uebp.apialunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uebp.apialunos.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findById(long id);
}
