package com.sistema.GestionAulas.Universidad.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.Universidad.Entity.Docente;
import com.sistema.GestionAulas.Universidad.Repository.DocenteRepository;
import com.sistema.GestionAulas.Universidad.Service.Interfaces.IDocenteService;

@Qualifier("docenteService")
@Service
public class DocenteService implements IDocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    @Override
    public void save(Docente Docente) {
        docenteRepository.save(Docente);
    }

    @Override
    public Docente findByID(long id) {
        return docenteRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        docenteRepository.deleteById(id);
    }

}