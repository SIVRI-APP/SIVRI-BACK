package edu.unicauca.SivriBackendApp.core.semillero.domain.model;

import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.SemilleroEntity;
import lombok.Data;

@Data
public class LineaInvestigacion {
    private Integer id;
    private String linea;
    private Integer semilleroId;

}
