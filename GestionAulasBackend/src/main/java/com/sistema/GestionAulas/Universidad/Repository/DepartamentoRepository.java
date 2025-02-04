package com.sistema.GestionAulas.Universidad.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.Universidad.Entity.Departamento;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {

    @SuppressWarnings("null")
    @Override
    List<Departamento> findAll();
}

