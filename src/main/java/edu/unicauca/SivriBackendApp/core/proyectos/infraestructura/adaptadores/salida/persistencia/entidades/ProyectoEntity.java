package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.ConvocatoriaEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "proyecto")
@Data
public class ProyectoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 256, nullable = false)
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

    private boolean eliminadoLogico;

    @OneToMany(mappedBy="proyecto", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<LineaDeInvestigacionProyectoEntity> lineasDeInvestigacion;

    @OneToMany(mappedBy="proyecto", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<IntegranteProyectoEntity> integrantes;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<EnfoqueDiferencialListadoEntity> enfoquesDiferenciales;

    @ManyToOne()
    @JoinColumn(name = "convocatoriaId")
    private ConvocatoriaEntity convocatoria;
}
