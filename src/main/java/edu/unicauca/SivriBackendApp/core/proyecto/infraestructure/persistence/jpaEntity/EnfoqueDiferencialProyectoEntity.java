package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private EnfoqueDiferencialEntity enfoqueDiferencial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyectoId")
    @JsonBackReference
    private ProyectoEntity proyecto;
}
