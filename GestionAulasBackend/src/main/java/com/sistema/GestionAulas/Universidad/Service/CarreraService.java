package com.sistema.GestionAulas.Universidad.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.Universidad.Entity.Carrera;
import com.sistema.GestionAulas.Universidad.Repository.CarreraRepository;
import com.sistema.GestionAulas.Universidad.Service.Interfaces.ICarreraService;

@Qualifier("carreraService")
@Service
public class CarreraService implements ICarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public List<Carrera> findAll() {
        return carreraRepository.findAll();
    }

    @Override
    public void save(Carrera carrera) {
        carreraRepository.save(carrera);
    }

    @Override
    public Carrera findByID(long id) {
        return carreraRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        carreraRepository.deleteById(id);
    }

}
