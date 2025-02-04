package com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "curso")
@Getter
@Setter
@RequiredArgsConstructor
public class Curso extends NotaPedido {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "codCurso", nullable = false, length = 60)
	private String carrera;

	@NotEmpty
	@Column(name = "proyector", nullable = false, length = 60)
	private boolean proyector;

}
