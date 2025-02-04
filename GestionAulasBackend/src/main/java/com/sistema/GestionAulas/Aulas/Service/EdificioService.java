package com.sistema.GestionAulas.Aulas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.Aulas.Entity.Edificio;
import com.sistema.GestionAulas.Aulas.Repository.EdificioRepository;
import com.sistema.GestionAulas.Aulas.Service.Interfaces.IEdificioService;

@Qualifier("edificioService")
@Service
public class EdificioService implements IEdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    @Override
    public List<Edificio> findAll() {

        return edificioRepository.findAll();
    }

    @Override
    public Edificio findByID(long id) {
        return edificioRepository.findById(id).orElse(null);
    }

}
