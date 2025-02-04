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
@Table(name = "laboratorio")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Getter
@Setter
@RequiredArgsConstructor
public class Laboratorio extends Aula {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "cantPC", nullable = false)
	private int cantPC;

	@NotEmpty
	@Column(name = "cantSillas", nullable = false)
	private int cantSillas;

}
