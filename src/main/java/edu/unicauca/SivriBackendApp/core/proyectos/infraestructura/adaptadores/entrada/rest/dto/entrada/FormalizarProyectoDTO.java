package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FormalizarProyectoDTO {

    @Positive(message = "El Id del Proyecto no es valido")
    private Long id;

    private String nombre;

    @FutureOrPresent(message = "La fecha de Inicio no puede ser en el pasado")
    private LocalDate fechaInicio;

    @FutureOrPresent(message = "La fecha de Fin no puede ser en el pasado")
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
