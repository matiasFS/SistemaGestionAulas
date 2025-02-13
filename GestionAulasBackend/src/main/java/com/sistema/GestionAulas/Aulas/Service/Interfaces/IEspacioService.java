package com.sistema.GestionAulas.Aulas.Service.Interfaces;

import java.time.LocalDate;
import java.util.List;

import com.sistema.GestionAulas.Aulas.Entity.Aula;
import com.sistema.GestionAulas.Aulas.Entity.Espacio;

public interface IEspacioService {

    public List<Espacio> findAll();

    public List<Espacio> findActives();

    public void save(Espacio espacio);

    public Espacio findByID(long id);

    public void delete(long id);

    public Espacio traerEspacio(long idAula, LocalDate fecha, char turno);

    public void agregarEspacioMes(int mes, int anio, char turno, Aula aula);

}
