package com.ufc.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ufc.web.model.*;

@Service
public class TurmaService {
    
    private List<Turma> turmas = new ArrayList<Turma>();
    
    public TurmaService() {
        List<Aluno> listAlunos = new ArrayList<Aluno>();
        listAlunos.addAll(Arrays.asList(new Aluno(1, "Renan", "renan@mail"), new Aluno(2, "Maria", "maria@mail")));

        turmas.addAll(
            Arrays.asList( // listAlunos Is Mock
                new Turma(1, "Web", 5, listAlunos),
                new Turma(2, "ES", 5, listAlunos)
            )
        );
    }
    
    public List<Turma> getTurmas() {
        return turmas;
    }

    public void addTurma(Turma turma) {
        turmas.add(turma);
    }
    
    public Turma getTurmaByCode(int codigo) {
        return turmas.stream().filter(t -> t.getCodigo() == codigo).findFirst().get();
    } 
    
    public Turma updateTurma(int codigo, Turma turma) {
    	Turma oldTurma = turmas.stream().filter(t -> t.getCodigo() == codigo).findFirst().get();
    	oldTurma.setDisciplina(turma.getDisciplina());
    	oldTurma.setSemestre(turma.getSemestre());
    	oldTurma.setAlunos(turma.getAlunos());
    	
    	return turma;
    } 
    
    public Boolean deleteTurma(int codigo) {
    	return turmas.remove(turmas.stream().filter(t -> t.getCodigo() == codigo).findFirst().get());
    }
    
    public List<Aluno> getAlunosByTurma(int codigo) {
        return turmas.stream().filter(t -> t.getCodigo() == codigo).findFirst().get().getAlunos();
    } 

    public List<Aluno> addAlunoInTurma(int codigo, Aluno aluno) {
        Turma turma = getTurmaByCode(codigo);
    	List<Aluno> alunosInTurma = turma.getAlunos();

    	alunosInTurma.add(aluno);
    	
    	return  alunosInTurma;
    }    

    public Boolean deleteAlunoInTurma(int codigo, int matricula) {
        Turma turma = getTurmaByCode(codigo);
    	List<Aluno> alunosInTurma = turma.getAlunos();
    	
    	return alunosInTurma.remove(alunosInTurma.stream().filter(a -> a.getMatricula() == matricula).findFirst().get());
    } 
}
