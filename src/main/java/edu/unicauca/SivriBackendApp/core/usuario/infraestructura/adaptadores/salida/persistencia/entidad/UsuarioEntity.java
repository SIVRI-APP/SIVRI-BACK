package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

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
     * Identificador único del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Correo electrónico del usuario. Es un campo obligatorio, único y tiene una longitud máxima de 60 caracteres.
     */
    @Column(name = "correo", length = 60, nullable = false, unique = true)
    private String correo;

    /**
     * Tipo de documento del usuario.
     */
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    /**
     * Número de documento del usuario. Tiene una longitud máxima de 45 caracteres.
     */
    @Column(name = "numeroDocumento", length = 45)
    private String numeroDocumento;

    /**
     * Género o sexo del usuario.
     */
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    /**
     * Tipo de usuario (administrativo, docente, pregrado, etc.).
     */
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    /**
     * Nombres del usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres.
     */
    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    /**
     * Apellidos del usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres.
     */
    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    /**
     * Número de teléfono del usuario. Es un campo obligatorio y tiene una longitud máxima de 45 caracteres.
     */
    @Column(name = "telefono", length = 45, nullable = false)
    private String telefono;

    /**
     * Enlace al Curriculum Vitae del usuario. Tiene una longitud máxima de 200 caracteres.
     */
    @Column(name = "cvLac", length = 200)
    private String cvLac;

    /**
     * Identificador de la facultad a la que pertenece el usuario.
     */
    private Long facultadId;

    /**
     * Identificador del departamento al que pertenece el usuario.
     */
    private Long departamentoId;

    /**
     * Identificador del programa al que pertenece el usuario.
     */
    private Long programaId;

}

