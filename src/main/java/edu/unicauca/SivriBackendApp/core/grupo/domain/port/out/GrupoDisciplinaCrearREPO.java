package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoDisciplina;

public interface GrupoDisciplinaCrearREPO {
    Boolean crear(GrupoDisciplina nuevosDatos);
}
