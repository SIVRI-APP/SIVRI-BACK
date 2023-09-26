package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProyectoCrearDTO {

    @NotNull(message = "El nombre del Proyecto no puede ser Nulo")
    @Size(min = 2, max = 256, message = "El nombre de la Proyecto debe estar entre 2 y 256 caracteres")
    private String nombre;

}
