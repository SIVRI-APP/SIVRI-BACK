package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "linea_de_inves_proyecto")
@Data
public class LineaDeInvestigacionProyectoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "linea_de_inves_proyecto_seq")
    @SequenceGenerator(name = "linea_de_inves_proyecto_seq", sequenceName = "linea_de_inves_proyecto_seq", initialValue = 10, allocationSize = 1)
    private Integer id;

    @Column(length = 250, nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    private ProyectoEntity proyecto;
}
