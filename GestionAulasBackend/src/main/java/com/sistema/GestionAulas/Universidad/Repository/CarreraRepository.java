package com.sistema.GestionAulas.Universidad.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.Universidad.Entity.Carrera;


@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {

    @SuppressWarnings("null")
    @Override
    List<Carrera> findAll();
}
