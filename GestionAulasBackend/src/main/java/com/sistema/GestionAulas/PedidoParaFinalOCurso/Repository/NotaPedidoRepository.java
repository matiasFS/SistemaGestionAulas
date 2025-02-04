package com.sistema.GestionAulas.PedidoParaFinalOCurso.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.NotaPedido;


@Repository
public interface NotaPedidoRepository extends CrudRepository<NotaPedido, Long> {

    @SuppressWarnings("null")
    @Override
    List<NotaPedido> findAll();

}
