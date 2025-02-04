package com.sistema.GestionAulas.Universidad.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carrera")
@Getter
@Setter
@RequiredArgsConstructor
public class Carrera implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	@NotEmpty
	@Column(name = "carrera", nullable = false, length = 60)
	private String carrera;

}
