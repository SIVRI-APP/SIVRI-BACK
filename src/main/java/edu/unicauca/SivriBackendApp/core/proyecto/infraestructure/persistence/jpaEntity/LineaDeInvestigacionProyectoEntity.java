package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "linea_de_investigacion_proyecto")
@Data
public class LineaDeInvestigacionProyectoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 250, nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    private ProyectoEntity proyecto;
}
