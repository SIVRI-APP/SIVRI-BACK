package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.Programa;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import lombok.Data;

@Data
public class SemilleroPrograma {
    private long id;
    private Semillero semillero;
    private Programa programa;
    private boolean eliminadoLogico;
}
