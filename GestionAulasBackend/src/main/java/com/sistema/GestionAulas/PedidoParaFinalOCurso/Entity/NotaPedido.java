package com.sistema.GestionAulas.PedidoParaFinalOCurso.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.sistema.GestionAulas.Aulas.Entity.Espacio;
import com.sistema.GestionAulas.Universidad.Entity.Materia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notaPedido")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "fecha", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	@Column(name = "turno", nullable = false, length = 1)
	private char turno;

	@NotBlank
	@Column(name = "aula", nullable = false, length = 60)
	private String aula;

	@Column(name = "cantEstudiantes", nullable = false)
	private int cantEstudiantes;

	@ManyToOne
	@JoinColumn(name = "materia_id")
	private Materia materia;

	@Column(name = "observaciones", length = 120)
	private String observaciones;

	@OneToOne
	@JoinColumn(name = "espacio_id")
	private Espacio espacio;

	public NotaPedido(LocalDate fecha, char turno, String aula, int cantEstudiantes, Materia materia, String observaciones){
		this.fecha = fecha;
		this.turno = turno;
		this.aula = aula;
		this.cantEstudiantes = cantEstudiantes;
		this.materia = materia;
		this.observaciones = observaciones;
	}
}
