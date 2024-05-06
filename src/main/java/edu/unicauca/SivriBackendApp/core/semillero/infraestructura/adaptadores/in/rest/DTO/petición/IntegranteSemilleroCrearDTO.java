package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IntegranteSemilleroCrearDTO {

    private int semilleroId;
    @NotNull(message = "El usuario no puede ser nulo")
    private Long usuarioId;
    //TODO falta el id del programa
    //private int programaId;
    @NotNull(message = "El rol del interante del semillero no puede ser Nulo")
    private Integer rolSemilleroId;

}
