package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "rolproyecto")
@Data
public class RolProyectoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String nombre;

    @OneToMany(mappedBy="rolProyecto", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<IntegranteProyectoEntity> integrantesProyectos;
}
