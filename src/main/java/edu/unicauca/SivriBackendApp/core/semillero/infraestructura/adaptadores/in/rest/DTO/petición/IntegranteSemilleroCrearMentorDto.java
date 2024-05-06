package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IntegranteSemilleroCrearMentorDto {
    private int semilleroId;
    private long usuarioId;
    @NotNull(message = "El rol del interante del semillero no puede ser Nulo")
    private Integer rolSemilleroId;

}
