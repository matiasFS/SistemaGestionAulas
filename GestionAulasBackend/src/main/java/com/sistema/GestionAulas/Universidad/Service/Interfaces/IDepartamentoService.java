package com.sistema.GestionAulas.Universidad.Service.Interfaces;

import java.util.List;

import com.sistema.GestionAulas.Universidad.Entity.Departamento;

public interface IDepartamentoService {

    public List<Departamento> findAll();

    public Departamento findByID(long id);

    public void save(Departamento departamento);

}