package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * Representa la entidad para las observaciones asociadas a las solicitudes de usuarios en el sistema.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSolicitudObservaciones {

    /** Identificador único de la observación asociada a la solicitud de usuario */
    private Long id;

    /** Solicitud de usuario a la que está asociada la observación. Es un campo obligatorio */
    private UsuarioSolicitud solicitudUsuario;

    /** Funcionario que realiza la observación. Es un campo obligatorio */
    private Funcionario funcionario;

    /** Conversaciones entórno a esta observación */
    private Set<UsuarioSolicitudConversacion> conversacion;

    /** Texto de la observación. Tiene una longitud máxima de 1000 caracteres y es un campo obligatorio */
    private String observación;

    /** Fecha en que se realiza la observación. Debe ser una fecha presente o futura */
    private LocalDate fechaObservación;

    /** Indica si la observación ha sido resuelta o no */
    private Boolean resuelta;

    /** Indica si se ha enviado una notificación de vencimiento asociada a esta observación */
    private Boolean notificaciónDeVencimiento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioSolicitudObservaciones that = (UsuarioSolicitudObservaciones) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

