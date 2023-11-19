package edu.unicauca.SivriBackendApp.core.grupo.domain.model;

import lombok.Data;

@Data
public class GrupoDisciplina {
    private long id;
    private Grupo grupo;
    private Disciplina disciplina;
}
