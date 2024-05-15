package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RechazarSolicitudDTO {

    @Size(min = 8, max = 1000, message = "La Observación debe contener mínimo 8 y máximo 60 caracteres")
    private String observacion;

    @NotNull(message = "El ID de la solicitud no puede ser nulo")
    private long usuarioSolicitudId;
}
