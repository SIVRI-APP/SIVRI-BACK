package edu.unicauca.SivriBackendApp.core.semillero.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LineaInvestigacionCrearDTO {
    //@NotNull(message = "el nombre de la linea no puede ser nulo.")
    @NotEmpty(message = "el nombre de la linea no puede ser nulo.")
    @NotBlank(message = "nombre invalido")
    private String linea;
}
