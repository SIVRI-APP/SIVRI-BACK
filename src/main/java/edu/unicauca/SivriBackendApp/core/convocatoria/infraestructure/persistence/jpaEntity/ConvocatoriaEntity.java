package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.ProyectoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "convocatoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConvocatoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String nombre;
    @Column(length = 250, nullable = false)
    private String objetivos;
    @Column(length = 45, nullable = false)
    private String oferente;
    @FutureOrPresent
    private LocalDate fechaInicio;
    @FutureOrPresent
    private LocalDate fechaFin;
    @Column(length = 45, nullable = false)
    private String estado;
    @Column(nullable = false)
    private boolean recurrente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipoFinanciacionId")
    private TipoFinanciacionEntity tipoFinanciacion;

    @OneToMany(mappedBy = "convocatoria", fetch = FetchType.EAGER)
    private List<ProyectoEntity> proyectos;
}
