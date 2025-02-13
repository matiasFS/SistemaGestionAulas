package com.sistema.GestionAulas.Aulas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.GestionAulas.Aulas.Entity.Aula;
import com.sistema.GestionAulas.Aulas.Service.AulaService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
@RequiredArgsConstructor
public class AulaController {

    @Autowired
	private AulaService aulaService;

	@GetMapping("/aulas")
	public ResponseEntity<List<Aula>> listAulas() {
		return ResponseEntity.ok(aulaService.findAll());
	}

}