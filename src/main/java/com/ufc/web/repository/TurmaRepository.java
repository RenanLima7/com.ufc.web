package com.ufc.web.repository;

import org.springframework.data.repository.CrudRepository;
import com.ufc.web.model.Turma;

public interface TurmaRepository extends CrudRepository<Turma, Integer> {
    Turma getTurmaByCode(int codigo);
    
    Boolean deleteTurmaByCode(int codigo);
}
