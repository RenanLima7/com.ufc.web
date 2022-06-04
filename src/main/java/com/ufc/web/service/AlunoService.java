package com.ufc.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.ufc.web.model.*;

@Service
public class AlunoService {
    private List<Aluno> alunos = new ArrayList<Aluno>();
        
    public AlunoService() {
        alunos.addAll(Arrays.asList(new Aluno(1, "Renan", "renan@mail"), new Aluno(1, "Maria", "maria@mail")));
    }
    
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    
    public Aluno getAlunoByMatricula(int matricula) {
        return alunos.stream().filter(a -> a.getMatricula() == matricula).findFirst().get();
    } 
    
    public Aluno updateAluno(int matricula, Aluno aluno) {
    	Aluno oldAluno = alunos.stream().filter(a -> a.getMatricula() == matricula).findFirst().get();
    	oldAluno.setMatricula(aluno.getMatricula());
    	oldAluno.setNome(aluno.getNome());
    	oldAluno.setEmail(aluno.getEmail());
    	
    	return aluno;
    } 
    
    public Boolean deleteAluno(int matricula) {
    	return alunos.remove(alunos.stream().filter(a -> a.getMatricula() == matricula).findFirst().get());
    } 
}