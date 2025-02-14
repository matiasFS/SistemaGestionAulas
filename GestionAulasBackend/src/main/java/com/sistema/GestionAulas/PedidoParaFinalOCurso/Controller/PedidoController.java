package com.sistema.GestionAulas.PedidoParaFinalOCurso.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Curso;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Final;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Service.NotaPedidoService;
import com.sistema.GestionAulas.Universidad.Service.MateriaService;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    @Qualifier("notaPedidoService")
    public NotaPedidoService pedidoService;

    @Autowired
    @Qualifier("materiaService")
    public MateriaService materiaService;

    @PreAuthorize("hasAuthority('ASSISTANT')")
    @PostMapping("/pedidoparafinal")
    public ResponseEntity<Final> createPedidoFinal(@RequestBody PedidoFinalRequest pedidoFinalRequest) {
        return ResponseEntity.ok(pedidoService.saveFinal(pedidoFinalRequest));
    }

    @PreAuthorize("hasAuthority('ASSISTANT')")
    @PostMapping("/pedidoparacurso")
    public ResponseEntity<Curso> createPedidoCurso(@RequestBody PedidoCursoRequest pedidoCursoRequest) {
        return ResponseEntity.ok(pedidoService.saveCurso(pedidoCursoRequest));
    }

    @PreAuthorize("hasAnyAuthority('ADMINGENERAL', 'ASSISTANT') ")
    @GetMapping("/listpedidosfinal")
    public ResponseEntity<List<Final>> listPedidosFinal() {
        return ResponseEntity.ok(pedidoService.getAllFinals());

    }

    @PreAuthorize("hasAnyAuthority('ADMINGENERAL', 'ASSISTANT') ")
    @GetMapping("/listpedidoscurso")
    public ResponseEntity<List<Curso>> listPedidoCurso(){
        return ResponseEntity.ok(pedidoService.getAllCursos());
    }
    
    @PreAuthorize("hasAuthority('ADMINGENERAL') ")
    @DeleteMapping("/pedidoparacurso/{id}")
    public ResponseEntity<Void> deletePedidoCurso(@PathVariable long id){
        pedidoService.deleteCurso(id);
        return ResponseEntity.ok().build();

    }

    @PreAuthorize("hasAuthority('ADMINGENERAL') ")
    @DeleteMapping("/pedidoparafinal/{id}")
    public ResponseEntity<Void> deletePedidoFinal(@PathVariable long id){
        pedidoService.deleteFinal(id);
        return ResponseEntity.ok().build();

    }
}

