package com.sistema.GestionAulas.PedidoParaFinalOCurso.Service;

import java.util.List;
import java.util.Optional;

import com.sistema.GestionAulas.PedidoParaFinalOCurso.Controller.PedidoCursoRequest;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Controller.PedidoFinalRequest;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Curso;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Final;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.NotaPedido;


public interface INotaPedidoService {

    public List<NotaPedido> getAllPedidos();

    public List<Final> getAllFinals();

    public List<Curso> getAllCursos();

    public Final saveFinal(PedidoFinalRequest saveFinal);

    public Curso saveCurso(PedidoCursoRequest pedidoCursoRequest);

    public NotaPedido save(NotaPedido notaPedido);

    public void deleteFinal(long id);

    public void deleteCurso(long id);

    public Optional<Final> findFinalByID(long id);

    public Optional<Curso> findCursoByID(long id);
}

