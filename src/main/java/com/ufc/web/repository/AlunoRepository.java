package com.ufc.web.repository;

import org.springframework.data.repository.CrudRepository;
import com.ufc.web.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
    Aluno getAlunoByMatricula(int matricula);

    Boolean deleteAlunoByMatricula(int matricula);
}
