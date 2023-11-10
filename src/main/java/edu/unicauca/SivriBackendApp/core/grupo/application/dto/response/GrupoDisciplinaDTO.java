package edu.unicauca.SivriBackendApp.core.grupo.application.dto.response;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import lombok.Data;

@Data
public class GrupoDisciplinaDTO {
    private long id;
    private ObtenerGruposDTO grupo;
    private ObtenerDisciplinaDTO disciplina;
}
