package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Semillero extends OrganismoDeInvestigacion {
    private Integer semillero_Id;
    private SemilleroEstado estado;
    private String correo;
    private String sede;
    private Integer grupoId;

}
