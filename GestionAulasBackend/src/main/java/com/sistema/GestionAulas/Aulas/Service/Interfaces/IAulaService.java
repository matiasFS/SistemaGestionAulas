package com.sistema.GestionAulas.Aulas.Service.Interfaces;

import java.util.List;

import com.sistema.GestionAulas.Aulas.Entity.Aula;
import com.sistema.GestionAulas.Aulas.Entity.Laboratorio;
import com.sistema.GestionAulas.Aulas.Entity.Tradicional;

public interface IAulaService {

    public List<Aula> findAll();

    public void save(Aula aula);

    public Tradicional findTradByID(long id);

    public Laboratorio findLabByID(long id);

    
    public List<Aula> findByEdificioId(long id);
}
