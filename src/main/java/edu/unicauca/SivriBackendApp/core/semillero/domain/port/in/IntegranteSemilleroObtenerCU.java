package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;

import java.util.List;

public interface IntegranteSemilleroObtenerCU {
    Respuesta<IntegranteSemillero> obtenerPorId(int id);

    Respuesta<List<IntegranteSemillero>> obtenerIntegrantesSemillero();
    Respuesta<List<Semillero>> obtenerSemillerosPorIdMentor(String idMentor);

}
