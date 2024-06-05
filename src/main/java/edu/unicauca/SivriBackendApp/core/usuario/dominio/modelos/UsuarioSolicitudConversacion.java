package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Representa la entidad de persistencia para las observaciones asociadas a las solicitudes de usuarios en el sistema.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSolicitudConversacion {

    /** Identificador único de la observación asociada a la solicitud de usuario */
    private Long id;

    /** Solicitud de usuario a la que está asociada la observación. Es un campo obligatorio */
    private UsuarioSolicitudObservaciones usuarioSolicitudObservaciones;

    /** Texto de la observación. Tiene una longitud máxima de 1000 caracteres y es un campo obligatorio */
    private String autor;

    /** Texto de la observación. Tiene una longitud máxima de 1000 caracteres y es un campo obligatorio. */
    private String mensaje;

    /** Fecha en que se realiza la observación. Debe ser una fecha presente o futura */
    private LocalDateTime fechaMensaje;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

