package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.entidad.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import lombok.Data;

/**
 * Representa la entidad de persistencia para los usuarios en el sistema.
 */
@Data
public class Usuario {

    /**
     * Identificador único de la solicitud de usuario.
     */
    private Long id;

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
    private ProgramaEntity programa;


}

