package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.ConvocatoriaEstado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "convocatoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConvocatoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250    , nullable = false)
    private String nombre;

    @Column(length = 250, nullable = false)
    private String objetivos;

    @Column(length = 90, nullable = false)
    private String oferente;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @Column(nullable = false)
    private boolean recurrente;

    @Column(nullable = false)
    private boolean eliminadoLogico;

    @Enumerated(EnumType.STRING)
    private ConvocatoriaEstado estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoFinanciacionId")
    private TipoFinanciacionEntity tipoFinanciacion;

//    @OneToMany(mappedBy = "convocatoria", fetch = FetchType.LAZY)
//    private List<ProyectoEntity> proyectos;
}
