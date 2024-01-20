package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta;

import lombok.Data;

@Data
public class ObtenerDisciplinaDTO {
    private Integer id;
    private String disciplina;
    private ObtenerSubAreasDTO subArea;
}
