package com.sistema.GestionAulas.Universidad.Entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "materia")
@Getter
@Setter
@RequiredArgsConstructor

public class Materia implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "codMateria", nullable = false, length = 30)
    private int codMateria;

    @NotEmpty
    @Column(name = "materia", nullable = false, length = 45)
    private String materia;

    // Faltan las relaciones entre carrera/docente con materia
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @ManyToMany
    @JoinTable(name = "materiaxdocente", joinColumns = @JoinColumn(name = "materiaId"), inverseJoinColumns = @JoinColumn(name = "docenteId"))
    private Set<Docente> docente;

}