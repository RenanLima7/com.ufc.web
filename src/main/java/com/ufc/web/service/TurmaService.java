package com.ufc.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufc.web.model.*;
import com.ufc.web.repository.*;

@Service
public class TurmaService {
    
    @Autowired 
    TurmaRepository turmaRepository;

    @Autowired 
    AlunoRepository alunoRepository;

    public Iterable<Turma> getTurmas() {
        return turmaRepository.findAll();
    }

    public void addTurma(Turma turma) {
        turmaRepository.save(turma);
    }
    
    public Turma getTurmaByCode(int codigo) {
        return turmaRepository.getTurmaByCode(codigo); // Verificar
    } 
    
    public Turma updateTurma(int codigo, Turma turma) {
    	//Turma oldTurma = turmas.stream().filter(t -> t.getCodigo() == codigo).findFirst().get();
    	//oldTurma.setDisciplina(turma.getDisciplina());
    	//oldTurma.setSemestre(turma.getSemestre());
    	//oldTurma.setAlunos(turma.getAlunos());
    	
    	return turma;
    } 
    
    public Boolean deleteTurmaByCode(int codigo) {
    	return turmaRepository.deleteTurmaByCode(codigo);
    }
    
    public List<Aluno> getAlunosByTurma(int codigo) {
        Turma turma = turmaRepository.getTurmaByCode(codigo);
        return turma.getAlunos();
    } 

    public List<Aluno> addAlunoInTurma(int codigo, Aluno aluno) {  // Verificar
        Turma turma = turmaRepository.getTurmaByCode(codigo);   
        List<Aluno> alunosInTurma = turma.getAlunos();
    	alunosInTurma.add(aluno);
        turma.setAlunos(alunosInTurma); // turma . save

        aluno.setTurma(turma);
        alunoRepository.save(aluno);
    	
    	return  alunosInTurma;
    }    

    public Boolean deleteAlunoInTurma(int codigo, int matricula) {
        Turma turma = turmaRepository.getTurmaByCode(codigo);
    	List<Aluno> alunosInTurma = turma.getAlunos();
        Aluno aluno = alunoRepository.getAlunoByMatricula(matricula);
    	
        alunosInTurma.remove(aluno); // verificar
        turma.setAlunos(alunosInTurma); // verificar

        aluno.setTurma(null);
        //alunoRepository.updateAluno(codigo, turma);

    	return alunosInTurma.remove(alunosInTurma.stream().filter(a -> a.getMatricula() == matricula).findFirst().get());
    } 
}
