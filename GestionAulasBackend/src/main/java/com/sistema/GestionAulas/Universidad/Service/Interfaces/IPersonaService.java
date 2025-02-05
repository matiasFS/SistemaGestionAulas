package com.sistema.GestionAulas.Universidad.Service.Interfaces;

import java.util.List;

import com.sistema.GestionAulas.Universidad.Entity.Persona;

public interface IPersonaService {

    public List<Persona> getAll();

    public Persona findByID(int id);

    public Persona findByDni(long dni);

    public Persona save(Persona persona);

    public List<Persona> listDni(Long dni);

}
