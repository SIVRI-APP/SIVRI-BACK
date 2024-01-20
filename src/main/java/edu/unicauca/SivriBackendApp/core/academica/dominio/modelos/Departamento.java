package edu.unicauca.SivriBackendApp.core.academica.dominio.modelos;

import lombok.Data;

@Data
public class Departamento {
    private Integer id;
    private String nombre;
    private Facultad facultad;
}
