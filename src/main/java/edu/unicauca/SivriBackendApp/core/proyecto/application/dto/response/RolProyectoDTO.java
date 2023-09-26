package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.IntegranteProyecto;
import lombok.Data;

import java.util.List;

@Data
public class RolProyectoDTO {

    private Integer id;

    private String nombre;

    private List<IntegranteProyecto> integrantesProyectos;
}
