package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ObservacionSemilleroCrearDTO {
    @NotEmpty(message = "La observacion no puede estar vacia")
    @NotBlank(message = "Datos invalidos")
    private String observacion;
}
