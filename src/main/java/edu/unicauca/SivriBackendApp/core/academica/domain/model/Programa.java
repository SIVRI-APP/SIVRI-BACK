package edu.unicauca.SivriBackendApp.core.academica.domain.model;

import lombok.Data;

@Data
public class Programa {
    private Integer id;
    private String nombre;
    private Departamento departamento;

}
