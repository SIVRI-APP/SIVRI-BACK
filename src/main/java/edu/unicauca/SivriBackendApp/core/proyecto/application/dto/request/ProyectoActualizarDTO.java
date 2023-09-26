package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProyectoActualizarDTO {

    @NotNull(message = "El id del Proyecto es necesario para su actualización")
    private Long id;

    @NotNull(message = "El nombre de la Convocatoria no puede ser Nulo")
    @Size(min = 2, max = 256, message = "El nombre de la Convocatoria debe estar entre 2 y 256 caracteres")
    private String nombre;

    @FutureOrPresent
    private LocalDate fechaInicio;

    @FutureOrPresent
    private LocalDate fechaFin;

    @Size(min = 2, max = 256, message = "El planteamiento debe estar entre 2 y 256 caracteres")
    private String planteamiento;

    @Size(min = 2, max = 256, message = "El planteamiento debe estar entre 2 y 256 caracteres")
    private String objetivoGeneral;

    @Size(min = 2, max = 256, message = "El planteamiento debe estar entre 2 y 256 caracteres")
    private String objetivosEspecificos;

    @Size(min = 2, max = 256, message = "El planteamiento debe estar entre 2 y 256 caracteres")
    private String justificacion;

    @Size(min = 2, max = 256, message = "El planteamiento debe estar entre 2 y 256 caracteres")
    private String enfoqueMetodologico;

    @Size(min = 2, max = 256, message = "El planteamiento debe estar entre 2 y 256 caracteres")
    private String aspectosEticosLegales;

    @Size(min = 2, max = 256, message = "El planteamiento debe estar entre 2 y 256 caracteres")
    private String confidencialidadDeInformacion;

    @Size(min = 2, max = 256, message = "El planteamiento debe estar entre 2 y 256 caracteres")
    private String efectosAdversos;

    @Size(min = 2, max = 256, message = "El planteamiento debe estar entre 2 y 256 caracteres")
    private String impactosResultadosEsperados;

    @Size(min = 2, max = 256, message = "El planteamiento debe estar entre 2 y 256 caracteres")
    private String consideraciones;

}
