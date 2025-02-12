package com.sistema.GestionAulas.PedidoParaFinalOCurso.Controller;

import java.time.LocalDate;

import com.sistema.GestionAulas.Universidad.Entity.Materia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoCursoRequest {

    LocalDate fecha;
    char turno;
    String aula;
    int cantEstudiantes;
    Materia materia;
    String observaciones;
    String carrera;
    boolean proyector;


}