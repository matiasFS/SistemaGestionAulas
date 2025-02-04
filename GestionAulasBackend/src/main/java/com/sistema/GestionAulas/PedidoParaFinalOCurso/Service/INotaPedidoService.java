package com.sistema.GestionAulas.PedidoParaFinalOCurso.Service;

import java.util.List;

import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Curso;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Final;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.NotaPedido;


public interface INotaPedidoService {

    public List<NotaPedido> listPedidos();

    public List<Final> getAll();

    public List<Curso> getAllCursos();

    public Final insertOrUpdate(Final saveFinal);

    public Curso insertOrUpdateCurso(Curso curso);

    public void save(NotaPedido notaPedido);

    public void deleteFinal(long id);

    public void deleteCurso(long id);

    public Final findFinalByID(long id);

    public Curso findCursoByID(long id);

}

