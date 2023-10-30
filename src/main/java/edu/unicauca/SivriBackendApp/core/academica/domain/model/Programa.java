package edu.unicauca.SivriBackendApp.core.academica.domain.model;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.DepartamentoEntity;
import lombok.Data;

@Data
public class Programa {
    private Integer id;
    private String nombre;
    private Departamento departamento;

}
