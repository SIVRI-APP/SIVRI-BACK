package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request;

import lombok.*;

import java.time.LocalDate;

@Data
public class ActualizarProyectoInfoGeneralDTO {

    private Integer id;

    private String nombre;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private String planteamiento;

    private String objetivoGeneral;

    private String objetivosEspecificos;

    private String justificacion;

    private String enfoqueMetodologico;

    private String aspectosEticosLegales;

    private String confidencialidadDeInformacion;

    private String efectosAdversos;

    private String impactosResultadosEsperados;

    private String consideraciones;

}
