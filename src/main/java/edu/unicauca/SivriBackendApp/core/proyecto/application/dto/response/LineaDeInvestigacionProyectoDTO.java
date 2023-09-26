package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import lombok.Data;

@Data
public class LineaDeInvestigacionProyectoDTO {

    private Integer id;

    private String nombre;

    private Proyecto proyecto;
}
