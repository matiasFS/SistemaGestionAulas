package com.sistema.GestionAulas.Aulas.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "espacio")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Espacio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NonNull
	@Column(name = "fecha", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	@NonNull
	@Column(name = "turno", nullable = false)
	private char turno;

	@NonNull
	@Column(name = "libre", nullable = false)
	private boolean libre;

	@ManyToOne
	@JoinColumn(name = "aula_id")
	private Aula aula;

	public Espacio(LocalDate fechaN, char turno, boolean libre, Aula aula){
		this.fecha = fechaN;
		this.turno = turno;
		this.libre = libre;
		this.aula = aula;
	}
}
