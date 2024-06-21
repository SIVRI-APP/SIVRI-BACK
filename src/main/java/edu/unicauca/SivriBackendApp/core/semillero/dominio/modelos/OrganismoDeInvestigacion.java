package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos;

import lombok.Data;

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