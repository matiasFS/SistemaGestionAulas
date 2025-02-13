package com.sistema.GestionAulas.Aulas.Service.Interfaces;

import java.util.List;

import com.sistema.GestionAulas.Aulas.Entity.Edificio;

public interface IEdificioService {

    
    public List<Edificio> findAll();

    public Edificio findByID(long id);

}

