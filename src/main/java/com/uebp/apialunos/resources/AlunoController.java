package com.uebp.apialunos.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uebp.apialunos.repository.AlunoRepository;

import com.uebp.apialunos.models.*;

@RestController
@RequestMapping(value="/api")
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepository;
	
	CursoController cursoController = new CursoController();
	
	@GetMapping("/alunos")
	public List<Aluno> listarAlunos() {
		return alunoRepository.findAll();
	}
	
	@GetMapping("/aluno/{id}")
	public Aluno listarAlunoPorId(@PathVariable(value="id") long id)  throws Exception {
		Aluno aluno;
		try {
			aluno = alunoRepository.findById(id);
			long idAluno = aluno.getId();
		}catch (Exception e) {
			throw new Exception("Aluno não encontrado");
		}
		return aluno;
	}
	
	@PostMapping("/aluno")
	public Aluno salvarAluno (@RequestBody Aluno aluno) throws Exception {
		
		Aluno alunoExistente = alunoRepository.findById(aluno.getId());
		
		if(alunoExistente != null) {
			throw new Exception("Erro: O Aluno já existe!");
		}		
		
		cursoController.listarCursoPorId(aluno.getIdCurso());
		
		try {
			return alunoRepository.save(aluno);
		}catch (Exception ex) {
			throw new Exception("Erro ao adicionar o aluno");
		}
		
	}
	
	@DeleteMapping("/aluno/{id}")
	public String removerAluno (@PathVariable(value="id") long id) throws Exception {
		Aluno aluno = listarAlunoPorId(id);
		alunoRepository.delete(aluno);
		
		return "Aluno Removido com sucesso!";
	}
	
	@PutMapping("/aluno")
	public Aluno editarAluno(@RequestBody Aluno aluno) throws Exception {
		try {
			alunoRepository.save(aluno);
		}catch (Exception e) {
			throw new Exception("Erro ao editar aluno.");
		}		
		
		return aluno;
	}
}
