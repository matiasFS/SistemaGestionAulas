package com.sistema.GestionAulas.Aulas.Entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "edificio")
@Getter
@Setter
@RequiredArgsConstructor
public class Edificio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@Column(name = "edificio", nullable = false)
	private String edificio;

	// El set si que no se como codearlo para la bd
	@NotEmpty
	@Column(name = "aulas", nullable = false)
	@OneToMany(mappedBy = "edificio")
	private Set<Aula> aulas;

}