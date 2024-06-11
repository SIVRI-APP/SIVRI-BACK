package edu.unicauca.SivriBackendApp.core.academica.dominio.modelo;

import lombok.Data;

/**
 * Clase que representa un Programa.
 */
@Data
public class Programa {

    /**
     * Identificador único del Programa.
     */
    private Integer id;

    /**
     * Nombre del Programa.
     */
    private String nombre;

    /**
     * Departamento al que pertenece el Programa.
     */
    private Departamento departamento;

    // Getters y setters omitidos para mayor claridad.
}
