package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.entidad;

import jakarta.persistence.*;
import lombok.*;

/**
 * Clase que representa una entidad de Facultad en la base de datos.
 */
@Entity
@Table(name = "facultad")
@Data
public class FacultadEntity {

    /**
     * Identificador único de la facultad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacultad;

    /**
     * Nombre de la facultad.
     */
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

}
