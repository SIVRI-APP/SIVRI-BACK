package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "enfoque_diferencial")
@Data
public class EnfoqueDiferencialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enfoque_diferencial_seq")
    @SequenceGenerator(name = "enfoque_diferencial_seq", sequenceName = "enfoque_diferencial_seq", initialValue = 10, allocationSize = 1)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "enfoqueDiferencial", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<EnfoqueDiferencialListadoEntity> proyectosDeEnfoque;
}
