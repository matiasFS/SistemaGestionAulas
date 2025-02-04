package com.sistema.GestionAulas.Universidad.Service.Interfaces;

import java.util.List;

import com.sistema.GestionAulas.Universidad.Entity.Materia;

public interface IMateriaService {

    public List<Materia> findAll();

    public void save(Materia materia);

    public Materia findByID(long id);

    public void delete(long id);

}
