package edu.unicauca.SivriBackendApp.core.proyecto.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proyecto {

    private Integer id;

    private String nombre;

    private EstadoProyecto estado;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private String planteamiento;

    private String objetivoGeneral;

    private String objetivosEspecificos;

    private String justificacion;

    private String enfoqueMetodologico;

    private String aspectosEticosLegales;

    private String confidencialidadDeInformacion;

    private String efectosAdversos;

    private String impactosResultadosEsperados;

    private String consideraciones;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "convocatoriaId")
//    private ConvocatoriaEntity convocatoria;
//
//    @OneToMany(mappedBy="proyecto", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
//    private List<IntegranteProyectoEntity> integrantes;
}
