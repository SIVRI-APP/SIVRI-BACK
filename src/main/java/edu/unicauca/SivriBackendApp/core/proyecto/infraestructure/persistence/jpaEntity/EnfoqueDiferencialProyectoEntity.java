package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "enfoque_diferencial_proyecto")
@Data
public class EnfoqueDiferencialProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enfoqueDiferencialId")
    private EnfoqueDiferencialEntity enfoqueDiferencial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyectoId")
    private ProyectoEntity proyecto;
}
