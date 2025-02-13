package com.sistema.GestionAulas.Aulas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@GetMapping("/edificios")
	public ResponseEntity<List<Edificio>> listarEdificios() {
		return ResponseEntity.ok(edificioService.findAll());

	}


	@GetMapping("/aulasdeledificio/{id}")
	public ResponseEntity<List<Aula>> listAulasDelEdificio(@PathVariable long id) {

		return ResponseEntity.ok(aulaService.findByEdificioId(id));
	}
	
/*@GetMapping("/{id}")
	public ModelAndView listarEdificiosYaulas(@PathVariable("id") Long idEdificio, Model model,
			RedirectAttributes attributes) {

		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDIFICIOYAULAS);

		Edificio edificio = null;
		if (idEdificio > 0) {
			edificio = edificioService.buscarPorID(idEdificio);
		}
		if (edificio == null) {
			attributes.addFlashAttribute("error", "*ERROR* el Edificio solicitado no existe");
			mAV.setViewName(ViewRouteHelper.LISTADOEDIFICIO);
		}

		List<Tradicional> tradicional = new ArrayList<>();
		List<Laboratorio> laboratorio = new ArrayList<>();

		for (Aula aula : edificio.getAulas()) {
			if (aula instanceof Tradicional) {
				tradicional.add((Tradicional) aula);
			}

			else {
				laboratorio.add((Laboratorio) aula);
			}

		}

		mAV.addObject("tradicional", tradicional);
		mAV.addObject("laboratorio", laboratorio);

		return mAV;

	} */
	

}
