package edu.unicauca.SivriBackendApp.core.convocatoria.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Convocatoria {

    private Long id;

    private String nombre;

    private String objetivos;

    private String oferente;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private boolean recurrente;

    private boolean eliminadoLogico;

    private ConvocatoriaEstado estado;

    private TipoFinanciacion tipoFinanciacion;

//    @OneToMany(mappedBy = "convocatoria", fetch = FetchType.LAZY)
//    private List<ProyectoEntity> proyectos;
}
