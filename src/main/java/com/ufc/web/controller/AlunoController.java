package com.ufc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.ufc.web.model.Aluno;
import com.ufc.web.service.AlunoService;

@RestController
public class AlunoController {
    @Autowired
	AlunoService alunoService;
     
	@GetMapping("/api/aluno")
	public List<Aluno> getAlunos() {
		return alunoService.getAlunos();
	}

	@PostMapping("/api/aluno")
	public void addAluno(@RequestBody Aluno aluno) {
		alunoService.addAluno(aluno);
	}

	@GetMapping("/api/aluno/{matricula}")
	public Aluno getAlunoByMatricula(@PathVariable int matricula) {
		return alunoService.getAlunoByMatricula(matricula);
	}
   
    @PutMapping("/api/aluno/{matricula}")
    public Aluno updateAluno(@PathVariable int matricula, @RequestBody Aluno aluno){
        return alunoService.updateAluno(matricula, aluno);
    }
   
    @DeleteMapping("/api/aluno/{matricula}")
    public void deleteAluno(@PathVariable int matricula){
        if (!alunoService.deleteAluno(matricula)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
