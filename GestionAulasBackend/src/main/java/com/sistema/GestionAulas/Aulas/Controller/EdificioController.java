package com.sistema.GestionAulas.Aulas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.GestionAulas.Aulas.Entity.Aula;
import com.sistema.GestionAulas.Aulas.Entity.Edificio;
import com.sistema.GestionAulas.Aulas.Service.AulaService;
import com.sistema.GestionAulas.Aulas.Service.EdificioService;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
@RequiredArgsConstructor
public class EdificioController {

	@Autowired
	private EdificioService edificioService;

    @Autowired
	private AulaService aulaService;

	@PreAuthorize("hasAnyAuthority('ADMINGENERAL', 'ASSISTANT') ")
	@GetMapping("/edificios")
	public ResponseEntity<List<Edificio>> listarEdificios() {
		return ResponseEntity.ok(edificioService.findAll());

	}

    @PreAuthorize("hasAnyAuthority('ADMINGENERAL', 'ASSISTANT') ")
	@GetMapping("/aulasdeledificio/{id}")
	public ResponseEntity<List<Aula>> listAulasDelEdificio(@PathVariable long id) {

		return ResponseEntity.ok(aulaService.findByEdificioId(id));
	}
}
