package com.sistema.GestionAulas.Universidad.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "docente")
@Getter
@Setter
@RequiredArgsConstructor
public class Docente extends Persona{

	@NotEmpty
	@Column(name = "nroLegajo")
	private int nroLegajo;

}