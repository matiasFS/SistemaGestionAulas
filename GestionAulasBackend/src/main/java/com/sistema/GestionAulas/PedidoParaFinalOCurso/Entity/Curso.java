package com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity;


import java.time.LocalDate;

import com.sistema.GestionAulas.Universidad.Entity.Materia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "curso")
@Getter
@Setter
public class Curso extends NotaPedido {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "codCurso", nullable = false, length = 60)
	private String carrera;

	
	@Column(name = "proyector", nullable = false, length = 60)
	private boolean proyector;

	public Curso(LocalDate fecha, char turno, String aula, int cantEstudiantes, Materia materia, String observaciones, String carrera, boolean proyector) {
		super(fecha, turno, aula, cantEstudiantes, materia, observaciones);
		this.carrera = carrera;
		this.proyector = proyector;
	}
}
