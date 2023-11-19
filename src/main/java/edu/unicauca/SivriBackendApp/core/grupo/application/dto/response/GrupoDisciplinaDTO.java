package edu.unicauca.SivriBackendApp.core.grupo.application.dto.response;

import lombok.Data;

@Data
public class GrupoDisciplinaDTO {
    private long id;
    private ObtenerGruposDTO grupo;
    private ObtenerDisciplinaDTO disciplina;
}
