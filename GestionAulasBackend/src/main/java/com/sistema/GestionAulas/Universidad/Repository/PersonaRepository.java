package com.sistema.GestionAulas.Universidad.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.Universidad.Entity.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

    @SuppressWarnings("null")
    @Override
    List<Persona> findAll();

    List<Persona> findByDni(Long dni);

    Persona findByDni(long dni);
}