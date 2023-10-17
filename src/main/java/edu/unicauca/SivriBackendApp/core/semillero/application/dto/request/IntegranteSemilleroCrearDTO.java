package edu.unicauca.SivriBackendApp.core.semillero.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IntegranteSemilleroCrearDTO {
    @NotNull(message = "El numero de documento no puede ser Nulo")
    @Size(min = 4,message = "el numero de documento debe ser mayor a 4 caracteres")
    private String numeroDocumento;

    private String semestre;
    @NotNull(message = "El rol del interante del semillero no puede ser Nulo")
    private Integer rolSemilleroId;


}
