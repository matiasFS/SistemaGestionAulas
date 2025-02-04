package com.sistema.GestionAulas.Aulas.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.Aulas.Entity.Aula;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Long> {

    @SuppressWarnings("null")
    @Override
    List<Aula> findAll();

}
