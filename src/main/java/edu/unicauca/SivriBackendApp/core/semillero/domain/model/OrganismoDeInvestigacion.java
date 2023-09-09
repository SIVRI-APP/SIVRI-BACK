package edu.unicauca.SivriBackendApp.core.semillero.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public abstract class OrganismoDeInvestigacion {

    private Integer id;
    private String nombre;
    private LocalDate fechaCreacion;
    private String estado;
    private String objetivo;
    private String mision;
    private String vision;
}
