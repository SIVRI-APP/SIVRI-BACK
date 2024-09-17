package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades;


import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * Representa la entidad de persistencia para las solicitudes de usuarios en el sistema.
 */
@Entity
@Table(name = "usuario_solicitud")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSolicitudEntity {

    /** Identificador único de la solicitud de usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /** Identifica al usuario que creo la solicitud */
    @ManyToOne(optional = false)
    @JoinColumn(name = "creadoPorUsuarioId")
    private UsuarioEntity creadoPor;

    /** Identificador del programa al que pertenece la solicitud de usuario */
    @ManyToOne()
    @JoinColumn(name = "programaId")
    private ProgramaEntity programa;

    /** Observaciones de la Solicitud */
    @OneToOne(mappedBy = "solicitudUsuario", cascade = CascadeType.REMOVE)
    private UsuarioSolicitudObservacionesEntity observaciones;

    /** Correo electrónico de la solicitud de usuario. Es un campo obligatorio, único y tiene una longitud máxima de 60 caracteres */
    @Column(name = "correo", length = 100, nullable = false, unique = true)
    private String correo;

    /** Tipo de documento de la solicitud de usuario */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento;

    /** Número de documento de la solicitud de usuario. Tiene una longitud máxima de 45 caracteres */
    @Column(name = "numeroDocumento", length = 100)
    private String numeroDocumento;

    /** Género o sexo de la solicitud de usuario */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    /** Estado de la solicitud de usuario (pendiente, aprobada, rechazada, etc.) */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoSolicitudUsuario estado;

    /** Tipo de usuario de la solicitud (administrativo, docente, pregrado, etc.) */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipoUsuario;

    /** Nombres de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres */
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    /** Apellidos de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres */
    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;

    /** Número de teléfono de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 45 caracteres */
    @Column(name = "telefono", length = 100, nullable = false)
    private String telefono;

    /** Enlace al Curriculum Vitae de la solicitud de usuario. Tiene una longitud máxima de 150 caracteres */
    @Column(name = "cvLac", length = 100)
    private String cvLac;

    /** Nota asociada a la solicitud de usuario. Tiene una longitud máxima de 1000 caracteres */
    @Column(length = 1000)
    private String nota;

    private String organismoDeInvestigacion;

    private Integer organismoDeInvestigacionId;

    private Integer rolId;


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

