package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Data Transfer Object (DTO) para rechazar una solicitud.
 */
@Data
public class RechazarSolicitudDTO {

    /**
     * Observación sobre el rechazo de la solicitud.
     * Debe contener entre 8 y 1000 caracteres.
     */
    @Size(min = 8, max = 1000, message = "La Observación debe contener mínimo 8 y máximo 1000 caracteres")
    private String observacion;

    /**
     * Id de la solicitud de usuario.
     * No puede ser nulo.
     */
    @NotNull(message = "El ID de la solicitud no puede ser nulo")
    private Long usuarioSolicitudId;

}
