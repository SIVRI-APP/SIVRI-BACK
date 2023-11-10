package edu.unicauca.SivriBackendApp.core.grupo.application.dto.response;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.SubArea;
import lombok.Data;

@Data
public class ObtenerDisciplinaDTO {
    private Integer id;
    private String disciplina;
    private ObtenerSubAreasDTO subArea;
}
