package edu.unicauca.SivriBackendApp.core.semillero.domain.model;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class Semillero extends OrganismoDeInvestigacion{
    private Integer semilleroId;
    private SemilleroEstado estado;
    private String sede;
    private Integer grupoId;
    //private List<IntegranteSemilleroEntity> integrantes;
    //private String mentorId;
}
