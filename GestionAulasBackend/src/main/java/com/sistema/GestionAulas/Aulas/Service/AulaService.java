package com.sistema.GestionAulas.Aulas.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.Aulas.Entity.Aula;
import com.sistema.GestionAulas.Aulas.Entity.Laboratorio;
import com.sistema.GestionAulas.Aulas.Entity.Tradicional;
import com.sistema.GestionAulas.Aulas.Repository.AulaRepository;
import com.sistema.GestionAulas.Aulas.Repository.LaboratorioRepository;
import com.sistema.GestionAulas.Aulas.Repository.TradicionalRepository;
import com.sistema.GestionAulas.Aulas.Service.Interfaces.IAulaService;

@Qualifier("aulaService")
@Service
public class AulaService implements IAulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private TradicionalRepository tradicionalRepository;

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @Override
    public List<Aula> findAll() {

        return (List<Aula>) aulaRepository.findAll();
    }

    @Override
    public void save(Aula aula) {
        aulaRepository.save(aula);
    }

    @Override
    public Tradicional findTradByID(long id) {
        List<Tradicional> tradicional = tradicionalRepository.findAll();
        Tradicional tradicional1 = null;
        for (Tradicional tradicional2 : tradicional) {
            if (tradicional2.getId() == id) {
                tradicional1 = tradicional2;
            }
        }
        return tradicional1;
    }

    @Override
    public Laboratorio findLabByID(long id) {
        List<Laboratorio> laboratorio = laboratorioRepository.findAll();
        Laboratorio laboratorio1 = null;
        for (Laboratorio laboratorio2 : laboratorio) {
            if (laboratorio2.getId() == id) {
                laboratorio1 = laboratorio2;
            }
        }
        return laboratorio1;
    }

    @Override
    public List<Aula> findByEdificioId(long id){
        return aulaRepository.findByEdificioId(id);
    }
}