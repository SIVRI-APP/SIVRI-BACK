package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IntegranteSemilleroCrearDTO {

    private int semilleroId;
    @NotNull(message = "El tipo de documento no puede ser nulo")
    private TipoDocumento tipoDocumento;
    @NotNull(message = "El numero de documento no puede ser Nulo")
    @NotBlank(message = "El numero de documento debe ser de tipo numerico")
    @Size(min = 5, max = 45, message = "El numero de documento debe contener minimo 5 y maximo 45 caracteres")
    private String numeroDocumento;
    @NotNull(message = "El rol del interante del semillero no puede ser Nulo")
    private Integer rolSemilleroId;

}
