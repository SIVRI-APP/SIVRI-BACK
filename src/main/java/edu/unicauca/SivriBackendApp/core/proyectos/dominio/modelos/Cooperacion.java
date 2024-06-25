package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.OrganismoDeInvestigacion;
import lombok.*;

import java.time.LocalDate;

@Data
public class Cooperacion {

    private Long id;

    private Boolean principal;

    private Boolean estado;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private Proyecto proyecto;

    private OrganismoDeInvestigacion organismoDeInvestigacion;

}
