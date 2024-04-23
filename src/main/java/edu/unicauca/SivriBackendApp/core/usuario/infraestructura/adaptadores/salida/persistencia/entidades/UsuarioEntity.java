package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.entidad.ProgramaEntity;
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
 * Representa la entidad de persistencia para los usuarios en el sistema.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class UsuarioEntity {

    /**
     * Identificador único de la solicitud de usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Correo electrónico de la solicitud de usuario. Es un campo obligatorio, único y tiene una longitud máxima de 60 caracteres.
     */
    @Column(name = "correo", length = 100, nullable = false, unique = true)
    private String correo;

    /**
     * Tipo de documento de la solicitud de usuario.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento;

    /**
     * Número de documento de la solicitud de usuario. Tiene una longitud máxima de 45 caracteres.
     */
    @Column(name = "numeroDocumento", length = 100)
    private String numeroDocumento;

    /**
     * Género o sexo de la solicitud de usuario.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    /**
     * Tipo de usuario de la solicitud (administrativo, docente, pregrado, etc.).
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipoUsuario;

    /**
     * Nombres de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres.
     */
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    /**
     * Apellidos de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres.
     */
    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;

    /**
     * Número de teléfono de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 45 caracteres.
     */
    @Column(name = "telefono", length = 100, nullable = false)
    private String telefono;

    /**
     * Enlace al Curriculum Vitae de la solicitud de usuario. Tiene una longitud máxima de 150 caracteres.
     */
    @Column(name = "cvLac", length = 100)
    private String cvLac;

    /**
     * Identificador del programa al que pertenece la solicitud de usuario.
     */
    @ManyToOne()
    @JoinColumn(name = "programaId")
    private ProgramaEntity programa;


}

