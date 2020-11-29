package com.uebp.apialunos.repository;

import com.uebp.apialunos.models.UserAluno;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAlunoRepository extends JpaRepository<UserAluno, Long> {
    UserAluno findByUsername(String username); // select u from UserAluno where u.username = ?1
}