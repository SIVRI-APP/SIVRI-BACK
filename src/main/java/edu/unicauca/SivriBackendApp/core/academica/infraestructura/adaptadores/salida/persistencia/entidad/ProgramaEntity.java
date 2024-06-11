package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.entidad;

import jakarta.persistence.*;
import lombok.*;

/**
 * Clase que representa una entidad de Programa en la base de datos.
 */
@Entity
@Table(name = "programa")
@Data
public class ProgramaEntity {

    /**
     * Identificador único del programa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nombre del programa.
     */
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    /**
     * Departamento al que pertenece el programa.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "departamentoId")
    private DepartamentoEntity departamento;
}

