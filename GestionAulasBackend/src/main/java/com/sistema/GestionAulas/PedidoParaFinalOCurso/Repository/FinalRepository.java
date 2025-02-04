package com.sistema.GestionAulas.PedidoParaFinalOCurso.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Final;

@Repository
public interface FinalRepository extends CrudRepository<Final, Long> {

    @SuppressWarnings("null")
    @Override
    List<Final> findAll();

    Final findByID(long id);
}
