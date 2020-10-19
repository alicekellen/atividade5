package com.uebp.apialunos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.uebp.apialunos.repository.CursoRepository;

import com.uebp.apialunos.models.*;

@RestController
@RequestMapping(value="/api")
public class CursoController {

	@Autowired
	CursoRepository cursoRepository;
	
	@GetMapping("/cursos")
	public List<Curso> listarCursos() {
		return cursoRepository.findAll();
	}
	
	@GetMapping("/curso/{id}")
	public Curso listarCursoPorId(@PathVariable(value="id") long id) throws Exception {
		Curso curso;
		try {
			curso = cursoRepository.findById(id);
			long idCurso = curso.getId();
		}catch (Exception e) {
			throw new Exception("Curso não encontrado");
		}
		return curso;
	}
	
	@PostMapping("/curso")
	public Curso salvarCurso (@RequestBody Curso curso) throws Exception {
		Curso cursoExistente = cursoRepository.findById(curso.getId());
		if(cursoExistente != null) {
			throw new Exception("Erro: O Curso já existe!");
		}
		
		try {
			return cursoRepository.save(curso);
		}catch (Exception ex) {
			throw new Exception("Erro ao adicionar o curso");
		}
	}
	
	@DeleteMapping("/curso/{id}")
	public String removerCurso (@PathVariable(value="id") long id) throws Exception {
		Curso curso = listarCursoPorId(id);
		cursoRepository.delete(curso);
		
		return "Curso Removido com sucesso!";
	}
	
	@PutMapping("/curso")
	public Curso editarCurso(@RequestBody Curso curso) throws Exception {
		try {
			cursoRepository.save(curso);
		}catch (Exception e) {
			throw new Exception("Erro ao editar curso.");
		}		
		
		return curso;
	}
}
