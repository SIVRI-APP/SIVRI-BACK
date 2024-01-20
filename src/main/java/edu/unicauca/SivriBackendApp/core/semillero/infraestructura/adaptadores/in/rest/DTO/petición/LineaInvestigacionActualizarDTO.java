package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LineaInvestigacionActualizarDTO {
    @NotEmpty(message = "el nombre de la linea no puede ser nulo.")
    @NotBlank(message = "nombre invalido")
    private String linea;
}
