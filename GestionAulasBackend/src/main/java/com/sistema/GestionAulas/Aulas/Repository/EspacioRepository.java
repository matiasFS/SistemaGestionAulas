package com.sistema.GestionAulas.Aulas.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.Aulas.Entity.Espacio;

@Repository
public interface EspacioRepository extends CrudRepository<Espacio, Long> {

    @SuppressWarnings("null")
    @Override
    List<Espacio> findAll();

    List<Espacio> findByLibreTrue();
}
