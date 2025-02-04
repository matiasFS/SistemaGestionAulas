package com.sistema.GestionAulas.PedidoParaFinalOCurso.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Curso;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Final;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.NotaPedido;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Repository.CursoRepository;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Repository.FinalRepository;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Repository.NotaPedidoRepository;

@Qualifier("notaPedidoService")
@Service
public class NotaPedidoService implements INotaPedidoService {

    @Autowired
    private NotaPedidoRepository notaRepository;

    @Autowired
    private FinalRepository finalRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<NotaPedido> listPedidos() {
        return (List<NotaPedido>) notaRepository.findAll();
    }

    @Override
    public void save(NotaPedido notaPedido) {
        notaRepository.save(notaPedido);
    }

    @Override
    public List<Final> getAll() {
        return finalRepository.findAll();
    }

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Final insertOrUpdate(Final final1) {
        return finalRepository.save(final1);
    }

    @Override
    public Curso insertOrUpdateCurso(Curso curso) {

        return cursoRepository.save(curso);
    }

    @Override
    public void deleteCurso(long id) {
        cursoRepository.deleteById(id);

    }

    @Override
    public void deleteFinal(long id) {
        finalRepository.deleteById(id);

    }
    @Override
    public Final findFinalByID(long id) {
        return finalRepository.findByID(id);
    }

    @Override
    public Curso findCursoByID(long id) {
        return cursoRepository.findByID(id);
    }

}
