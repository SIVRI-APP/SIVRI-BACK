package edu.unicauca.SivriBackendApp.core.academica.domain.model;

import lombok.Data;

@Data
public class Departamento {
    private Integer id;
    private String nombre;
    private Facultad facultad;
}
