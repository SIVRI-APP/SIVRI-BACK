package edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrganismoDeInvestigacion {
    private Integer id;
    private String nombre;
    private LocalDate fechaCreacion;
    private String objetivo;
    private String mision;
    private String vision;
}
