package com.sistema.GestionAulas.Aulas.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tradicional")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Getter
@Setter
@RequiredArgsConstructor
public class Tradicional extends Aula {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "cantBancos", nullable = false)
	private int cantBancos;

	@NotEmpty
	@Column(name = "pizarron", nullable = false)
	private String pizarron;

	@NotEmpty
	@Column(name = "tieneProyector", nullable = false)
	private int tieneProyector;

}