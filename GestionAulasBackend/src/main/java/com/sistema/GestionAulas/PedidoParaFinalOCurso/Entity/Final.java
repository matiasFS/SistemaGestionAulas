package com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.sistema.GestionAulas.Universidad.Entity.Materia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "final")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Final extends NotaPedido {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "fechaExamen", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaExamen;

	public Final(LocalDate fecha, char turno, String aula, int cantEstudiantes, Materia materia, String observaciones, LocalDate fechaExamen){
		super(fecha, turno, aula, cantEstudiantes, materia, observaciones);
		this.fechaExamen = fechaExamen;
	}
}
