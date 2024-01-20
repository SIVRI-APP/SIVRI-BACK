package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Semillero extends OrganismoDeInvestigacion {
    private Integer semilleroId;
    private SemilleroEstado estado;
    private String sede;
    private Integer grupoId;

}
