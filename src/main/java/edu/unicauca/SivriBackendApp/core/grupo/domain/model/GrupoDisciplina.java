package edu.unicauca.SivriBackendApp.core.grupo.domain.model;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.DisciplinaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.GrupoEntity;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
public class GrupoDisciplina {
    private long id;
    private Grupo grupo;
    private Disciplina disciplina;
}
