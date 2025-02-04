package com.sistema.GestionAulas.Universidad.Service.Interfaces;

import java.util.List;

import com.sistema.GestionAulas.Universidad.Entity.Docente;

public interface IDocenteService {

    public List<Docente> findAll();

    public void save(Docente docente);

    public Docente findByID(long id);

    public void delete(long id);

}
