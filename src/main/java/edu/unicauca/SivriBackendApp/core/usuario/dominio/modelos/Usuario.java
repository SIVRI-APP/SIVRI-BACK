package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * La clase Usuario representa a un usuario en el sistema.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    /**
     * Identificador único del usuario.
     */
    private Long id;

    /**
     * Correo electrónico del usuario.
     */
    private String correo;

    /**
     * Tipo de documento de identificación del usuario.
     */
    private TipoDocumento tipoDocumento;

    /**
     * Número de documento de identificación del usuario.
     */
    private String numeroDocumento;

    /**
     * Género o sexo del usuario.
     */
    private Sexo sexo;

    /**
     * Tipo de usuario en el sistema.
     */
    private TipoUsuario tipoUsuario;

    /**
     * Nombres del usuario.
     */
    private String nombres;

    /**
     * Apellidos del usuario.
     */
    private String apellidos;

    /**
     * Número de teléfono del usuario.
     */
    private String telefono;

    /**
     * Enlace al Curriculum Vitae LAC del usuario.
     */
    private String cvLac;

    /**
     * Identificador único de la facultad a la que pertenece el usuario.
     */
    private Long facultadId;

    /**
     * Identificador único del departamento al que pertenece el usuario.
     */
    private Long departamentoId;

    /**
     * Identificador único del programa académico al que pertenece el usuario.
     */
    private Long programaId;
}
