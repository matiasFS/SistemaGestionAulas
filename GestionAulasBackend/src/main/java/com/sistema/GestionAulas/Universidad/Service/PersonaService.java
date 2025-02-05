package com.sistema.GestionAulas.Universidad.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.Universidad.Entity.Persona;
import com.sistema.GestionAulas.Universidad.Repository.PersonaRepository;
import com.sistema.GestionAulas.Universidad.Service.Interfaces.IPersonaService;

@Qualifier("personaService")
@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getAll() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public Persona findByID(int id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> listDni(Long dni) {

        return personaRepository.findByDni(dni);
    }

    @Override
    public Persona findByDni(long dni) {
        return personaRepository.findByDni(dni);
    }

}