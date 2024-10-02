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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enfoque_diferencial_list_seq")
    @SequenceGenerator(name = "enfoque_diferencial_list_seq", sequenceName = "enfoque_diferencial_list_seq", initialValue = 10, allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENFOQUE_DIFERENCIAL_ID")
    @JsonManagedReference
    private EnfoqueDiferencialEntity enfoqueDiferencial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROYECTO_ID")
    @JsonBackReference
    private ProyectoEntity proyecto;
}
