package edu.unicauca.SivriBackendApp.core.semillero.domain.port.out;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;

import java.util.List;
import java.util.Optional;

public interface IntegranteSemilleroObtenerREPO {
    Optional<IntegranteSemillero> obtenerPorId(int id);

    List<IntegranteSemillero> obtenerIntegrantesSemillero();
    List<Semillero> obtenerSemillerosPorIdMentor(String idMentor);
}
