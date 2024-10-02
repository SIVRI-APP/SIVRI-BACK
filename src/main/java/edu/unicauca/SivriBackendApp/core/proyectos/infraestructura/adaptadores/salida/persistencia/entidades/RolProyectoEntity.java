package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "rol_proyecto")
@Data
public class RolProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_proyecto_seq")
    @SequenceGenerator(name = "rol_proyecto_seq", sequenceName = "rol_proyecto_seq", initialValue = 10, allocationSize = 1)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RolProyectoEnum nombre;

    @OneToMany(mappedBy="rolProyecto", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<IntegranteProyectoEntity> integrantesProyectos;
}
