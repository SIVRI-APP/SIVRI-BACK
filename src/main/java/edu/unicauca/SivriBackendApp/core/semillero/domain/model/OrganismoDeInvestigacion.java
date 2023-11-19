package edu.unicauca.SivriBackendApp.core.semillero.domain.model;

import lombok.*;

import java.time.LocalDate;
@Data
public abstract class OrganismoDeInvestigacion {

    private Integer id;
    private String nombre;
    private LocalDate fechaCreacion;
    private String objetivo;
    private String mision;
    private String vision;
}
