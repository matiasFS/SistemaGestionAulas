package com.sistema.GestionAulas.Universidad.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.Universidad.Entity.Materia;
import com.sistema.GestionAulas.Universidad.Repository.MateriaRepository;
import com.sistema.GestionAulas.Universidad.Service.Interfaces.IMateriaService;

@Qualifier("materiaService")
@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public List<Materia> findAll() {

        return materiaRepository.findAll();
    }

    @Override
    public void save(Materia materia) {
        materiaRepository.save(materia);
    }

    @Override
    public Materia findByID(long id) {
        return materiaRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        materiaRepository.deleteById(id);
    }

}
