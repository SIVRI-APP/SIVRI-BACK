package edu.unicauca.SivriBackendApp.core.academica.domain.model;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import lombok.Data;

@Data
public class SemilleroPrograma {
    private long id;
    private Semillero semillero;
    private Programa programa;
    private boolean eliminadoLogico;
}
