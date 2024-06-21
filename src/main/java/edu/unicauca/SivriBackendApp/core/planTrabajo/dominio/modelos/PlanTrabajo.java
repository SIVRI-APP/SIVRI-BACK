package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import lombok.Data;

@Data
public class PlanTrabajo {
    private Integer id;
    private String nombrePlan;
    private EstadoPlanTrabajo estado;
    private Semillero semillero;
    private Integer anio;
}
