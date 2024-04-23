package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Programa;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import lombok.Data;

/**
 * Representa la entidad de persistencia para las solicitudes de usuarios en el sistema.
 */
@Data
public class UsuarioSolicitud {

    /**
     * Identificador único de la solicitud de usuario.
     */
    private Long id;

    /**
     * Identifica al usuario que creo la solicitud.
     */
    private Usuario creadoPor;

    /**
     * Correo electrónico de la solicitud de usuario. Es un campo obligatorio, único y tiene una longitud máxima de 60 caracteres.
     */
    private String correo;

    /**
     * Tipo de documento de la solicitud de usuario.
     */
    private TipoDocumento tipoDocumento;

    /**
     * Número de documento de la solicitud de usuario. Tiene una longitud máxima de 45 caracteres.
     */
    private String numeroDocumento;

    /**
     * Género o sexo de la solicitud de usuario.
     */
    private Sexo sexo;

    /**
     * Estado de la solicitud de usuario (pendiente, aprobada, rechazada, etc.).
     */
    private EstadoSolicitudUsuario estado;

    /**
     * Tipo de usuario de la solicitud (administrativo, docente, pregrado, etc.).
     */
    private TipoUsuario tipoUsuario;

    /**
     * Nombres de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres.
     */
    private String nombre;

    /**
     * Apellidos de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres.
     */
    private String apellido;

    /**
     * Número de teléfono de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 45 caracteres.
     */
    private String telefono;

    /**
     * Enlace al Curriculum Vitae de la solicitud de usuario. Tiene una longitud máxima de 150 caracteres.
     */
    private String cvLac;

    /**
     * Identificador del programa al que pertenece la solicitud de usuario.
     */
    private Programa programa;

    /**
     * Identificador del organismo de Investigación al que se relaciona la solicitud de usuario. Es un campo obligatorio.
     */
    private Integer organismoDeInvestigacionId;

    /**
     * Identificador del rol del organismo de Investigación asociado a la solicitud de usuario. Es un campo obligatorio.
     */
    private Integer rolGrupoId;

    /**
     * Nota asociada a la solicitud de usuario. Tiene una longitud máxima de 1000 caracteres.
     */
    private String nota;
}

