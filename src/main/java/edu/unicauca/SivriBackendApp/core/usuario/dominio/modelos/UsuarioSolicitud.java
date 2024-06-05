package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Programa;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import lombok.*;

import java.util.Objects;

/**
 * Representa la entidad para las solicitudes de usuarios en el sistema.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioSolicitud {

    /** Identificador único de la solicitud de usuario */
    private Long id;

    /** Identifica al usuario que creo la solicitud */
    private Usuario creadoPor;

    /** Identificador del programa al que pertenece la solicitud de usuario */
    private Programa programa;

    /** Observaciones de la Solicitud */
    private UsuarioSolicitudObservaciones observaciones;

    /** Correo electrónico de la solicitud de usuario. Es un campo obligatorio, único y tiene una longitud máxima de 60 caracteres */
    private String correo;

    /** Tipo de documento de la solicitud de usuario */
    private TipoDocumento tipoDocumento;

    /** Número de documento de la solicitud de usuario. Tiene una longitud máxima de 45 caracteres */
    private String numeroDocumento;

    /** Género o sexo de la solicitud de usuario */
    private Sexo sexo;

    /** Estado de la solicitud de usuario (pendiente, aprobada, rechazada, etc.) */
    private EstadoSolicitudUsuario estado;

    /** Tipo de usuario de la solicitud (administrativo, docente, pregrado, etc.) */
    private TipoUsuario tipoUsuario;

    /** Nombres de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres */
    private String nombre;

    /** Apellidos de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres */
    private String apellido;

    /** Número de teléfono de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 45 caracteres */
    private String telefono;

    /** Enlace al Curriculum Vitae de la solicitud de usuario. Tiene una longitud máxima de 150 caracteres */
    private String cvLac;

    /** Nota asociada a la solicitud de usuario. Tiene una longitud máxima de 1000 caracteres */
    private String nota;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioSolicitud that = (UsuarioSolicitud) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

