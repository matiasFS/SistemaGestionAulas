package com.sistema.GestionAulas.Universidad.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.Universidad.Entity.Departamento;
import com.sistema.GestionAulas.Universidad.Repository.DepartamentoRepository;
import com.sistema.GestionAulas.Universidad.Service.Interfaces.IDepartamentoService;

@Qualifier("departamentoService")
@Service
public class DepartamentoService implements IDepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento findByID(long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Departamento departamento) {
        departamentoRepository.save(departamento);
    }

}