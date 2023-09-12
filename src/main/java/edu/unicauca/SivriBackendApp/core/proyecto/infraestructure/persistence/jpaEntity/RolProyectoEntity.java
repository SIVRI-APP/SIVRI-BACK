package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.*;

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
    private List<IntegranteProyectoEntity> integrantesProyectos;
}
