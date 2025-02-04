package com.sistema.GestionAulas.Aulas.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.Aulas.Entity.Tradicional;

@Repository
public interface TradicionalRepository extends CrudRepository<Tradicional, Long> {

    @SuppressWarnings("null")
    @Override
    List<Tradicional> findAll();
}
