package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * Representa la entidad de persistencia para los usuarios en el sistema.
 */
@Entity
@Table(name = "usuario")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

    /** Identificador único de la solicitud de usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", initialValue = 20, allocationSize = 1)
    private Long id;

    /** Correo electrónico de la solicitud de usuario. Es un campo obligatorio, único y tiene una longitud máxima de 60 caracteres */
    @Column(length = 100, nullable = false, unique = true)
    private String correo;

    /** Tipo de documento de la solicitud de usuario */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipoDocumento;

    /** Número de documento de la solicitud de usuario. Tiene una longitud máxima de 45 caracteres */
    @Column(length = 100)
    private String numeroDocumento;

    /** Género o sexo de la solicitud de usuario */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    /** Tipo de usuario de la solicitud (administrativo, docente, pregrado, etc.) */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipoUsuario;

    /** Nombres de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres */
    @Column(length = 100, nullable = false)
    private String nombre;

    /** Apellidos de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 100 caracteres */
    @Column(length = 100, nullable = false)
    private String apellido;

    /** Número de teléfono de la solicitud de usuario. Es un campo obligatorio y tiene una longitud máxima de 45 caracteres */
    @Column(length = 100, nullable = false)
    private String telefono;

    /** Enlace al Curriculum Vitae de la solicitud de usuario. Tiene una longitud máxima de 150 caracteres */
    @Column(length = 100)
    private String cvLac;

    private Integer departamentoId;

    private Integer programaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

