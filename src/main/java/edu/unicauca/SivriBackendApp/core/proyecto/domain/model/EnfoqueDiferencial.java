package edu.unicauca.SivriBackendApp.core.proyecto.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class EnfoqueDiferencial {

    private Integer id;

    private String nombre;

    private List<EnfoqueDiferencialProyecto> proyectosDeEnfoque;
}
