package com.sistema.GestionAulas.Aulas.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.GestionAulas.Aulas.Entity.Espacio;
import com.sistema.GestionAulas.Aulas.Service.EspacioService;

import lombok.RequiredArgsConstructor;




@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
@RequiredArgsConstructor
public class EspacioController {
    
    @Autowired
    private EspacioService espacioService;

    @PreAuthorize("hasAnyAuthority('ADMINGENERAL', 'ASSISTANT') ")
    @GetMapping("/espacios")
    public ResponseEntity<List<Espacio>> listEspacios(){
        return ResponseEntity.ok(espacioService.findAll());
    }

    @PreAuthorize("hasAnyAuthority('ADMINGENERAL', 'ASSISTANT') ")
    @GetMapping("/buscarespacio/{id}")
    public ResponseEntity<Espacio> findEspacio( @PathVariable long id, @RequestParam LocalDate fecha, @RequestParam char turno){
        Espacio espacio = espacioService.traerEspacio(id, fecha, turno);
    
        if (espacio == null) {
            return ResponseEntity.notFound().build();
        }
            
        return ResponseEntity.ok(espacio);
    }

    @PreAuthorize("hasAuthority('ADMINGENERAL') ")
    @PostMapping("/asignarespacio/{id}")
    public ResponseEntity<Espacio> asignarEspacio(@PathVariable long id, @RequestParam Long idNotaPedido) {
        return espacioService.asignarEspacio(id, idNotaPedido)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    
    
}
