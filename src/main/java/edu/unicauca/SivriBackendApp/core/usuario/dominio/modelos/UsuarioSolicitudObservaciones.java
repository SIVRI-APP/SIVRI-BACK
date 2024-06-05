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

    /** Identificador único de la observacion asociada a la solicitud de usuario */
    private Long id;

    /** Solicitud de usuario a la que está asociada la observacion. Es un campo obligatorio */
    private UsuarioSolicitud solicitudUsuario;

    /** Funcionario que realiza la observacion. Es un campo obligatorio */
    private Funcionario funcionario;

    /** Conversaciones entórno a esta observacion */
    private Set<UsuarioSolicitudConversacion> conversacion;

    /** Texto de la observacion. Tiene una longitud máxima de 1000 caracteres y es un campo obligatorio */
    private String observacion;

    /** Fecha en que se realiza la observacion. Debe ser una fecha presente o futura */
    private LocalDate fechaObservacion;

    /** Indica si la observacion ha sido resuelta o no */
    private Boolean resuelta;

    /** Indica si se ha enviado una notificación de vencimiento asociada a esta observacion */
    private Boolean notificacionDeVencimiento;

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

