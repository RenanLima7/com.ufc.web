package com.ufc.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.ufc.web.model.*;
import com.ufc.web.repository.*;

@Service
public class AlunoService {

    @Autowired
	AlunoRepository alunoRepository;
        
    @GetMapping
    public Iterable<Aluno> getAlunos(){
        return alunoRepository.findAll();
    }
   
    @PostMapping
    public Aluno addAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }
       
    public Aluno getAlunoByMatricula(int matricula) {
        return alunoRepository.getAlunoByMatricula(matricula); // Verificar
    }    
    
    public Aluno updateAluno(int matricula, Aluno aluno) {
    	//Aluno oldAluno = alunoRepository.
    	//oldAluno.setMatricula(aluno.getMatricula());
    	///oldAluno.setNome(aluno.getNome());
    	//oldAluno.setEmail(aluno.getEmail());
    	
    	return aluno;
    } 
    
    public Boolean deleteAlunoByMatricula(int matricula) {
    	return alunoRepository.deleteAlunoByMatricula(matricula);
    } 
}