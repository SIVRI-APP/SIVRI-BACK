package edu.unicauca.SivriBackendApp.core.academica.domain.port.out;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;

import java.util.List;
import java.util.Optional;

public interface SemilleroProgramaObtenerREPO {
    Boolean existePorId(long id);
    Optional<SemilleroPrograma> obtenerPorId(long id);
    List<SemilleroPrograma> obtenerListadoProgramasPorSemilleroId(int idSemillero);

}
