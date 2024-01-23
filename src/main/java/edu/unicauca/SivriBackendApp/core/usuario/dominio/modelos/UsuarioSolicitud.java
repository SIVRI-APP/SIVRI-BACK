package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase UsuarioSolicitud representa una solicitud de usuario en el sistema.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSolicitud {

    /**
     * Identificador único de la solicitud de usuario.
     */
    private Long id;

    /**
     * Correo electrónico del solicitante.
     */
    private String correo;

    /**
     * Tipo de documento de identificación del solicitante.
     */
    private TipoDocumento tipoDocumento;

    /**
     * Número de documento de identificación del solicitante.
     */
    private String numeroDocumento;

    /**
     * Género o sexo del solicitante.
     */
    private Sexo sexo;

    /**
     * Estado actual de la solicitud de usuario.
     */
    private EstadoSolicitudUsuario estado;

    /**
     * Tipo de usuario solicitado.
     */
    private TipoUsuario tipoUsuario;

    /**
     * Nombres del solicitante.
     */
    private String nombres;

    /**
     * Apellidos del solicitante.
     */
    private String apellidos;

    /**
     * Número de teléfono del solicitante.
     */
    private String telefono;

    /**
     * Enlace al Curriculum Vitae LAC del solicitante.
     */
    private String cvLac;

    /**
     * Identificador único de la facultad a la que pertenece el solicitante.
     */
    private Long facultadId;

    /**
     * Identificador único del departamento al que pertenece el solicitante.
     */
    private Long departamentoId;

    /**
     * Identificador único del programa académico al que pertenece el solicitante.
     */
    private Long programaId;

    /**
     * Identificador del grupo al que desea unirse el solicitante (puede ser nulo).
     */
    private Integer grupoId;

    /**
     * Identificador del rol dentro del grupo al que desea unirse el solicitante (puede ser nulo).
     */
    private Integer rolGrupoId;

    /**
     * Nota o comentario asociado a la solicitud.
     */
    private String nota;
}
