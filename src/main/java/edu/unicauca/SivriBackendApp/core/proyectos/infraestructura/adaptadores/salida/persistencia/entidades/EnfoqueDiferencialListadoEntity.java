package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "enfoque_diferencial_list")
@Data
public class EnfoqueDiferencialListadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
