package edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response;


import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.EnfoqueDiferencial;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import lombok.Data;

@Data
public class EnfoqueDiferencialProyectoDTO {

    private Integer id;

    private EnfoqueDiferencial enfoqueDiferencial;

    private Proyecto proyecto;
}
