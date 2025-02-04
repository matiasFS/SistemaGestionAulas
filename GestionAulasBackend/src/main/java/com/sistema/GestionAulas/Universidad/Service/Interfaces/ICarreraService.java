package com.sistema.GestionAulas.Universidad.Service.Interfaces;

import java.util.List;

import com.sistema.GestionAulas.Universidad.Entity.Carrera;

public interface ICarreraService {

    public List<Carrera> findAll();

    public void save(Carrera carrera);

    public Carrera findByID(long id);

    public void delete(long id);

}

