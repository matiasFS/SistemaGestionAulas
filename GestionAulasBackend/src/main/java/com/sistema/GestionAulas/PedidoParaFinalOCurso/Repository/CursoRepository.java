package com.sistema.GestionAulas.PedidoParaFinalOCurso.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {

    @SuppressWarnings("null")
    @Override
    List<Curso> findAll();

}