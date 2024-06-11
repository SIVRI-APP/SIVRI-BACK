package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Representa la entidad de las conversaciones asociadas a las observaciones asociadas a las solicitudes de usuarios en el sistema.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSolicitudConversacion {

    /** Identificador único de la observacion asociada a la solicitud de usuario */
    private Long id;

    /** Solicitud de usuario a la que está asociada la observacion. Es un campo obligatorio */
    private UsuarioSolicitudObservaciones usuarioSolicitudObservaciones;

    /** Texto de la observacion. Tiene una longitud máxima de 1000 caracteres y es un campo obligatorio */
    private String autor;

    /** Texto de la observacion. Tiene una longitud máxima de 1000 caracteres y es un campo obligatorio. */
    private String mensaje;

    /** Fecha en que se realiza la observacion. Debe ser una fecha presente o futura */
    private LocalDateTime fechaMensaje;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioSolicitudConversacion that = (UsuarioSolicitudConversacion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

