package com.sistema.GestionAulas.Universidad.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.Universidad.Entity.Docente;

@Repository
public interface DocenteRepository extends CrudRepository<Docente, Long> {
   
    @SuppressWarnings("null")
    @Override
    List<Docente> findAll();
}
