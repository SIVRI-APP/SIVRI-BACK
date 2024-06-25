package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada;

import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FormalizarProyectoDTO {

    @Positive(message = "El Id del Proyecto no es valido")
    private Long id;

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
