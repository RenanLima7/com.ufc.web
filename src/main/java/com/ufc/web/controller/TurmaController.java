package com.ufc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.ufc.web.model.*;
import com.ufc.web.service.TurmaService;

@RestController
public class TurmaController {

	@Autowired
	TurmaService turmaService;
	
	@GetMapping("/api/turma")
	public List<Turma> getTurmas() {
		return turmaService.getTurmas();
	}

	@PostMapping("/api/turma")
	public void addTurma(@RequestBody Turma turma) {
		turmaService.addTurma(turma);
	}

	@GetMapping("/api/turma/{code}")
	public Turma getTurmaByCode(@PathVariable int code) {
		return turmaService.getTurmaByCode(code);
	}
   
    @PutMapping("/api/turma/{code}")
    public Turma updateTurma(@PathVariable int code, @RequestBody Turma turma){
        return turmaService.updateTurma(code, turma);
    }
   
    @DeleteMapping("/api/turma/{code}")
    public void deleteTurma(@PathVariable int code){
        if (!turmaService.deleteTurma(code)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    } 

	@GetMapping("/api/turma/{code}/alunos")
	public List<Aluno> getAlunosByTurma(@PathVariable int code) {
		return turmaService.getAlunosByTurma(code);
	}

	@PostMapping("/api/turma/{code}/alunos")
	public List<Aluno> addAlunoInTurma(@PathVariable int code, @RequestBody Aluno aluno) {
		return turmaService.addAlunoInTurma(code, aluno);
	}

	@DeleteMapping("/api/turma/{code}/alunos/{matricula}")
    public void deleteAlunoInTurma(@PathVariable int code, @PathVariable int matricula){
        if (!turmaService.deleteAlunoInTurma(code, matricula)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    } 
}