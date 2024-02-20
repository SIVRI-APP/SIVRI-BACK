package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarObservacionesPorIdSemillero;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ObservacionSemilleroObtenerCU {

    Respuesta<Boolean> existePorId(int id);
    Respuesta<ObservacionSemillero> obtenerPorId(int id);
    Respuesta<Page<List<ListarObservacionesPorIdSemillero>>> listarObservacionesPorIdSemillero(int pageNo, int pageSize, int semilleroId);

}
