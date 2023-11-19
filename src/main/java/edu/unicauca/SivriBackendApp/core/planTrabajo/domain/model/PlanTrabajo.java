package edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import lombok.Data;

@Data
public class PlanTrabajo {
    private Integer id;
    private String nombrePlan;
    private EstadoPlanTrabajo estado;
    private Semillero semillero;

}
