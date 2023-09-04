package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "enfoque_diferencial")
@Data
public class EnfoqueDiferencialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "enfoqueDiferencial", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<EnfoqueDiferencialProyectoEntity> enfoquesDiferenciales;
}
