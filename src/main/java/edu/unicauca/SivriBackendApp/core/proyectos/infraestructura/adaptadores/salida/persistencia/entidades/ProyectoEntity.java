package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.ConvocatoriaEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "proyecto")
@Getter
@Setter
public class ProyectoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proyecto_seq")
    @SequenceGenerator(name = "proyecto_seq", sequenceName = "proyecto_seq", initialValue = 20, allocationSize = 1)
    private Long id;

    @Column(length = 256, nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    private EstadoProyecto estado;

    private LocalDate fechaInicio;

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
    private String confidencialidad;

    @Column(length = 256)
    private String efectosAdversos;

    @Column(length = 256)
    private String impacResulEsperados;

    @Column(length = 256)
    private String consideraciones;

    private boolean eliminadoLogico;

    @ManyToOne()
    @JoinColumn(name = "CONVOCATORIA_ID")
    private ConvocatoriaEntity convocatoria;

    @OneToMany(mappedBy="proyecto", cascade = CascadeType.REMOVE)
    private List<LineaDeInvestigacionProyectoEntity> lineasDeInvestigacion;

    @OneToMany(mappedBy="proyecto", cascade = CascadeType.REMOVE)
    private Set<IntegranteProyectoEntity> integrantes;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.REMOVE)
    private List<EnfoqueDiferencialListadoEntity> enfoquesDiferenciales;

    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.REMOVE)
    private Set<EvidenciaProyectoDocumentoConvocatoriaEntity> evidenciasDocumentosConvocatoria;

    @OneToMany(mappedBy="proyecto", cascade = CascadeType.REMOVE)
    private Set<CompromisoProyectoEntity> compromisos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProyectoEntity that = (ProyectoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
