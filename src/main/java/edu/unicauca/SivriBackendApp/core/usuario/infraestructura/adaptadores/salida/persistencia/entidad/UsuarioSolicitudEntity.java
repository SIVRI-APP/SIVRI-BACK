package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa la entidad de persistencia para las solicitudes de usuarios en el sistema.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario_solicitud")
public class UsuarioSolicitudEntity {

    /**
     * Identificador único de la solicitud de usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Correo electrónico de la solicitud de usuario. Es un campo obligatorio, único y tiene una longitud máxima de 60 caracteres.
     */
    @Column(name = "correo", length = 60, nullable = false, unique = true)
    private String correo;

    /**
     * Tipo de documento de la solicitud de usuario.
     */
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    /**
     * Número de documento de la solicitud de usuario. Tiene una longitud máxima de 45 caracteres.
     */
    @Column(name = "numeroDocumento", length = 45)
    private String numeroDocumento;

    /**
     * Género o sexo de la solicitud de usuario.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    /**
     * Estado de la solicitud de usuario (pendiente, aprobada, rechazada, etc.).
     */
    @Enumerated(EnumType.STRING)
    private EstadoSolicitudUsuario estado;

    /**
     * Tipo de usuario de la solicitud (administrativo, docente, pregrado, etc.).
     */
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    /**
     * Nombres de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres.
     */
    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    /**
     * Apellidos de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres.
     */
    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    /**
     * Número de teléfono de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 45 caracteres.
     */
    @Column(name = "telefono", length = 45, nullable = false)
    private String telefono;

    /**
     * Enlace al Curriculum Vitae de la solicitud de usuario. Tiene una longitud máxima de 150 caracteres.
     */
    @Column(name = "cvLac", length = 150)
    private String cvLac;

    /**
     * Identificador de la facultad a la que pertenece la solicitud de usuario.
     */
    private Long facultadId;

    /**
     * Identificador del departamento al que pertenece la solicitud de usuario.
     */
    private Long departamentoId;

    /**
     * Identificador del programa al que pertenece la solicitud de usuario.
     */
    private Long programaId;

    /**
     * Nota asociada a la solicitud de usuario. Tiene una longitud máxima de 1000 caracteres.
     */
    @Column(length = 1000)
    private String nota;

    /**
     * Identificador del grupo al que se relaciona la solicitud de usuario. Es un campo obligatorio.
     */
    @Column(nullable = false)
    private Integer grupoId;

    /**
     * Identificador del rol de grupo asociado a la solicitud de usuario. Es un campo obligatorio.
     */
    @Column(nullable = false)
    private Integer rolGrupoId;

    // Otros campos y métodos getters/setters...
}

