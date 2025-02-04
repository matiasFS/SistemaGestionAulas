package com.sistema.GestionAulas.Aulas.Repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.Aulas.Entity.Edificio;

@Repository
public interface EdificioRepository extends CrudRepository<Edificio, Long> {

    @SuppressWarnings("null")
    @Override
    List<Edificio> findAll();

}
