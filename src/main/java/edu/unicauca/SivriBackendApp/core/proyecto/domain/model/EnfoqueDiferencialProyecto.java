package edu.unicauca.SivriBackendApp.core.proyecto.domain.model;


import lombok.Data;

@Data
public class EnfoqueDiferencialProyecto {

    private Integer id;

    private EnfoqueDiferencial enfoqueDiferencial;

    private Proyecto proyecto;
}
