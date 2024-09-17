package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa una entidad de Departamento en la base de datos.
 */
@Entity
@Table(name = "departamento")
@Data
public class DepartamentoEntity {

    /**
     * Identificador único del departamento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    /**
     * Nombre del departamento.
     */
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    /**
     * Facultad a la que pertenece el departamento.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "facultadId")
    private FacultadEntity facultad;

}