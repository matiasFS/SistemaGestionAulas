package com.sistema.GestionAulas.PedidoParaFinalOCurso.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.PedidoParaFinalOCurso.Controller.PedidoCursoRequest;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Controller.PedidoFinalRequest;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Curso;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Final;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.NotaPedido;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Repository.CursoRepository;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Repository.FinalRepository;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Repository.NotaPedidoRepository;
import com.sistema.GestionAulas.Universidad.Entity.Materia;
import com.sistema.GestionAulas.Universidad.Repository.MateriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Qualifier("notaPedidoService")
@Service
public class NotaPedidoService implements INotaPedidoService {

    @Autowired
    private NotaPedidoRepository notaRepository;

    @Autowired
    private FinalRepository finalRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired 
    private MateriaRepository materiaRepository;

    @Override
    public List<NotaPedido> getAllPedidos() {
        return (List<NotaPedido>) notaRepository.findAll();
    }

    @Override
    public NotaPedido save(NotaPedido notaPedido) {
        return notaRepository.save(notaPedido);
    }

    @Override
    public List<Final> getAllFinals() {
        return finalRepository.findAll();
    }

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Final saveFinal(PedidoFinalRequest pedidoFinalRequest) {
        Materia materia = materiaRepository.findById(pedidoFinalRequest.getMateria().getId());
        Final savePedidoFinal = new Final(pedidoFinalRequest.getFecha(), pedidoFinalRequest.getTurno(), pedidoFinalRequest.getAula(), pedidoFinalRequest.getCantEstudiantes(), materia, pedidoFinalRequest.getObservaciones(), pedidoFinalRequest.getFechaExamen());
        return finalRepository.save(savePedidoFinal);
    }

    @Override
    public Curso saveCurso(PedidoCursoRequest pedidoCursoRequest) {
        Materia materia = materiaRepository.findById(pedidoCursoRequest.getMateria().getId());
        Curso savePedidoCurso = new Curso(pedidoCursoRequest.getFecha(), pedidoCursoRequest.getTurno(), pedidoCursoRequest.getAula(), pedidoCursoRequest.getCantEstudiantes(), materia, pedidoCursoRequest.getObservaciones(), pedidoCursoRequest.getCarrera(), pedidoCursoRequest.isProyector());
        return cursoRepository.save(savePedidoCurso);
    }

    @Override
    public void deleteCurso(long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            cursoRepository.deleteById(curso.get().getId());
        } else {
            throw new EntityNotFoundException("Pedido no encontrado con ID: " + id);
        }
        

    }

    @Override
    public void deleteFinal(long id) {
        Optional<Final> final1 = finalRepository.findById(id);
        if (final1.isPresent()) {
            finalRepository.deleteById(final1.get().getId());
        } else {
            throw new EntityNotFoundException("Pedido no encontrado con ID: " + id);
        }
        

    }

    @Override
    public Optional<Final> findFinalByID(long id) {
        return finalRepository.findById(id);
    }

    @Override
    public Optional<Curso> findCursoByID(long id) {
        return cursoRepository.findById(id);
    }
   
    

}
