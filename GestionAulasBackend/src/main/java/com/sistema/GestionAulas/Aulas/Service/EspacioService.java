package com.sistema.GestionAulas.Aulas.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.Aulas.Entity.Aula;
import com.sistema.GestionAulas.Aulas.Entity.Espacio;
import com.sistema.GestionAulas.Aulas.Repository.EspacioRepository;
import com.sistema.GestionAulas.Aulas.Service.Interfaces.IEspacioService;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Curso;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity.Final;
import com.sistema.GestionAulas.PedidoParaFinalOCurso.Service.NotaPedidoService;

@Qualifier("espacioService")
@Service
public class EspacioService implements IEspacioService {

	@Autowired
	private EspacioRepository espacioRepository;

	@Autowired
	private NotaPedidoService notaPedidoService;

	@Override
	public List<Espacio> findAll() {

		return espacioRepository.findAll();
	}

	@Override
	public void save(Espacio espacio) {
		espacioRepository.save(espacio);
	}

	@Override
	public Espacio findByID(long id) {
		return espacioRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(long id) {
		espacioRepository.deleteById(id);
	}

	@Override
	public List<Espacio> findActives() {
		return espacioRepository.findByLibreTrue();
	}

	@Override
	public Espacio traerEspacio(long idAula, LocalDate fecha, char turno) {
		return espacioRepository.findByAulaIdAndFechaAndTurno(idAula, fecha, turno);
	}

    @Override
	public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) {

		LocalDate hoy = LocalDate.of(anio, mes, 1);
		// Obtiene el largo del mes EJ: mayo = 31 dias
		int largoMes = hoy.lengthOfMonth();
		// Fecha que ira variando en el for

		LocalDate fechaN = LocalDate.of(anio, mes, 1);

		for (int i = 0; i < largoMes; i++) {
			if (fechaN.getDayOfMonth() == 1 && i == 0) {

				if (traerEspacio(aula.getId(), fechaN, turno) == null) {
					Espacio espacio = new Espacio(fechaN, turno, true, aula);
					save(espacio);
				}

			} else {
				fechaN = fechaN.plusDays(1);

				if (traerEspacio(aula.getId(), fechaN, turno) == null) {

					Espacio espacio = new Espacio(fechaN, turno, true, aula);
					save(espacio);
				}

			}

		}

	}

	@Override
	public Optional<Espacio> asignarEspacio(long idEspacio, long idNotaPedido) {
    	Espacio espacio = findByID(idEspacio);
   		if (espacio == null || !espacio.isLibre()) {
        	return Optional.empty();
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
        	return Optional.empty();
    	}

    	espacio.setLibre(false);
    	save(espacio);
    	return Optional.of(espacio);
	}

}
