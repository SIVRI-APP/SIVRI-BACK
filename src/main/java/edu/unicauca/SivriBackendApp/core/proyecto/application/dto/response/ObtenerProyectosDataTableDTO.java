package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ObtenerProyectosDataTableDTO {
    private Integer id;

    private String nombre;

    private String estado;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}
