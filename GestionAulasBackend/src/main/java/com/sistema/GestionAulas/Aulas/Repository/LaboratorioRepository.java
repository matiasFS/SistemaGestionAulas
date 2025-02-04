package com.sistema.GestionAulas.Aulas.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.Aulas.Entity.Laboratorio;

@Repository
public interface LaboratorioRepository extends CrudRepository<Laboratorio, Long> {

    @SuppressWarnings("null")
    @Override
    List<Laboratorio> findAll();
}

