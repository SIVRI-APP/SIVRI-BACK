package edu.unicauca.SivriBackendApp.core.academica.domain.model;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.FacultadEntity;
import lombok.Data;

@Data
public class Departamento {
    private Integer id;
    private String nombre;
    private Facultad facultad;
}
