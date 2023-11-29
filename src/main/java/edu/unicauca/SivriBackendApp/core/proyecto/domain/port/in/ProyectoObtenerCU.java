package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProyectoObtenerCU {
    Respuesta<Boolean> existePorId(long id);
    Respuesta<Proyecto> obtenerPorId(long id);
    Respuesta<List<Proyecto>> obtenerListado();
    Respuesta<Page<Proyecto>> obtenerListadoPaginado(int pageNo, int pageSize);
}
