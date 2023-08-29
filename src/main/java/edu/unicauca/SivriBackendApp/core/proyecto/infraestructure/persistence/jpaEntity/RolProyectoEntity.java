package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rolproyecto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolProyectoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String nombre;

    @OneToMany(mappedBy="rolProyecto", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<IntegranteProyectoEntity> integrantesProyectos;
}
