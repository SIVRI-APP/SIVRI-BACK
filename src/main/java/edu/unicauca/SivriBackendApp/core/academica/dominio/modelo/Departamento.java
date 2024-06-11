package edu.unicauca.SivriBackendApp.core.academica.dominio.modelo;

import lombok.Data;

/**
 * Clase que representa un Departamento.
 */
@Data
public class Departamento {

    /**
     * Identificador único del Departamento.
     */
    private Integer id;

    /**
     * Nombre del Departamento.
     */
    private String nombre;

    /**
     * Facultad a la que pertenece el Departamento.
     */
    private Facultad facultad;

    // Getters y setters omitidos para mayor claridad.
}
