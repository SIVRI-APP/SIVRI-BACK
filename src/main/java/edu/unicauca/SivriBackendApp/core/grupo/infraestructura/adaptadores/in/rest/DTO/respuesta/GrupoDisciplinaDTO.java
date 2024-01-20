package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta;

import lombok.Data;

@Data
public class GrupoDisciplinaDTO {
    private long id;
    private ObtenerGruposDTO grupo;
    private ObtenerDisciplinaDTO disciplina;
}
