package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.EnfoqueDiferencialProyecto;
import lombok.Data;

import java.util.List;

@Data
public class EnfoqueDiferencialDTO {

    private Integer id;

    private String nombre;

    private List<EnfoqueDiferencialProyecto> enfoquesDiferenciales;
}
