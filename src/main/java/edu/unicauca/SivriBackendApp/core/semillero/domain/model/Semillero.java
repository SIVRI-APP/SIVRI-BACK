package edu.unicauca.SivriBackendApp.core.semillero.domain.model;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.IntegranteSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.usuario.domain.Usuario;
import lombok.*;

import java.util.List;

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
