package edu.unicauca.SivriBackendApp.core.semillero.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SemilleroObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Semillero> obtenerSemilleroPorId(int id);
    Respuesta<List<Semillero>> obtenerSemillerosPorIdGrupo(int idGrupo);
    Respuesta<List<Semillero>> obtenerSemillerosPorIdMentor(String idMentor);
    Respuesta<List<Semillero>> obtenerSemilleros();
    Respuesta<Page<Semillero>> obtenerSemillerosPaginado(int pageNo, int pageSize);
}
