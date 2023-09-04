package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.ConvocatoriaEntity;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.EstadoProyecto;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "proyecto")
@Data
public class ProyectoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 245, nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    private EstadoProyecto estado;

    @FutureOrPresent
    private LocalDate fechaInicio;

    @FutureOrPresent
    private LocalDate fechaFin;

    @Column(length = 256)
    private String planteamiento;

    @Column(length = 256)
    private String objetivoGeneral;

    @Column(length = 256)
    private String objetivosEspecificos;

    @Column(length = 256)
    private String justificacion;

    @Column(length = 256)
    private String enfoqueMetodologico;

    @Column(length = 256)
    private String aspectosEticosLegales;

    @Column(length = 256)
    private String confidencialidadDeInformacion;

    @Column(length = 256)
    private String efectosAdversos;

    @Column(length = 256)
    private String impactosResultadosEsperados;

    @Column(length = 256)
    private String consideraciones;

    @ManyToOne()
    @JoinColumn(name = "convocatoriaId")
    private ConvocatoriaEntity convocatoria;

    @OneToMany(mappedBy="proyecto", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<IntegranteProyectoEntity> integrantes;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<EnfoqueDiferencialProyectoEntity> enfoquesDiferenciales;
}
