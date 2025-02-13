package com.sistema.GestionAulas.Aulas.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.GestionAulas.Aulas.Entity.Espacio;
import com.sistema.GestionAulas.Aulas.Service.EspacioService;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Curso;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Final;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Service.NotaPedidoService;

import lombok.RequiredArgsConstructor;




@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
@RequiredArgsConstructor
public class EspacioController {
    
    @Autowired
    private EspacioService espacioService;

    @Autowired
    private NotaPedidoService notaPedidoService;

    @GetMapping("/espacios")
    public ResponseEntity<List<Espacio>> listEspacios(){
        return ResponseEntity.ok(espacioService.findAll());
    }

    @GetMapping("/buscarespacio/{id}")
    public ResponseEntity<Espacio> findEspacio( @PathVariable long id,
        @RequestParam LocalDate fecha,
        @RequestParam char turno){
            Espacio espacio = espacioService.traerEspacio(id, fecha, turno);
    
            // Handle case where the espacio is not found
            if (espacio == null) {
                return ResponseEntity.notFound().build();
            }
            
            return ResponseEntity.ok(espacio);
    }

    @PostMapping("/asignarespacio/{id}")
public ResponseEntity<Espacio> asignarEspacio(@PathVariable long id, @RequestParam Long idNotaPedido) {
    Espacio espacio = espacioService.findByID(id);
    if (espacio == null || !espacio.isLibre()) {
        return ResponseEntity.badRequest().build();
    }

    Optional<Final> pedidoFinal = notaPedidoService.findFinalByID(idNotaPedido);
    Optional<Curso> pedidoCurso = notaPedidoService.findCursoByID(idNotaPedido);

    if (pedidoFinal.isPresent()) {
        Final final1 = pedidoFinal.get();
        final1.setEspacio(espacio);
        notaPedidoService.save(final1);
    } else if (pedidoCurso.isPresent()) {
        Curso curso = pedidoCurso.get();
        curso.setEspacio(espacio);
        notaPedidoService.save(curso);
    } else {
        return ResponseEntity.badRequest().build();
    }

    // Mark Espacio as occupied
    espacio.setLibre(false);
    espacioService.save(espacio);

    return ResponseEntity.ok(espacio); // Returning the updated Espacio
}

    
    
}
