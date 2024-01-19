package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.petición;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class devolverSolicitudConObservacionesDTO {
    @NotNull(message = "Debe seleccionar una solicitud para denegarla")
    private long solicitudUsuarioId;

    @NotNull(message = "Debe describir el motivo del rechazo")
    @Size(min = 10, max = 1000, message = "El motivo del rechazo debe contener entre 10 y 1000 caracteres")
    private String observación;
}
