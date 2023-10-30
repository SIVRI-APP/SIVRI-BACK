package edu.unicauca.SivriBackendApp.core.academica.application.dto.response;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.Programa;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import lombok.Data;

@Data
public class SemilleroProgramaDTO {
    private long id;
    private Semillero semillero;
    private Programa programa;

}
