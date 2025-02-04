package com.sistema.GestionAulas.Universidad.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.Universidad.Entity.Materia;

@Repository

public interface MateriaRepository extends CrudRepository<Materia, Long> {

    @SuppressWarnings("null")
    @Override
    List<Materia> findAll();

}

