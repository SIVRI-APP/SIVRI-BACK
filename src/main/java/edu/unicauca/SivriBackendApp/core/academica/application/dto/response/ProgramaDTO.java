package edu.unicauca.SivriBackendApp.core.academica.application.dto.response;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.Departamento;
import lombok.Data;

@Data
public class ProgramaDTO {
    private Integer id;
    private String nombre;
    private Departamento departamento;

}
