package com.sistema.GestionAulas.PedidoParaFinalOCurso.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    @Qualifier("notaPedidoService")
    public NotaPedidoService pedidoService;

    @Autowired
    @Qualifier("materiaService")
    public MateriaService materiaService;

    @PostMapping("/final")
    public ResponseEntity<Final> createPedidoFinal(@RequestBody PedidoFinalRequest pedidoFinalRequest) {
        return ResponseEntity.ok(pedidoService.saveFinal(pedidoFinalRequest));
    }

    
    @PostMapping("/curso")
    public ResponseEntity<Curso> createPedidoCurso(@RequestBody PedidoCursoRequest pedidoCursoRequest) {
        return ResponseEntity.ok(pedidoService.saveCurso(pedidoCursoRequest));
    }

    @GetMapping("/listPedidosFinal")
    public ResponseEntity<List<Final>> listPedidosFinal() {
        return ResponseEntity.ok(pedidoService.getAllFinals());

    }

    @GetMapping("/listPedidosCurso")
    public ResponseEntity<List<Curso>> listPedidoCurso(){
        return ResponseEntity.ok(pedidoService.getAllCursos());
    }
    
    @DeleteMapping("/curso/{id}")
    public ResponseEntity<Void> deletePedidoCurso(@PathVariable long id){
        pedidoService.deleteCurso(id);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/final/{id}")
    public ResponseEntity<Void> deletePedidoFinal(@PathVariable long id){
        pedidoService.deleteFinal(id);
        return ResponseEntity.ok().build();

    }
}

