package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarLineasInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.LineaInvestigacionEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LineaInvestigacionObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<LineaInvestigacion> obtenerPorId(int id);
    Respuesta<Page<List<ListarLineasInvestigacion>>> obtenerLineasInvestigacionPorSemilleroId(int pageNo, int pageSize, int idSemillero);
    Respuesta<List<LineaInvestigacion>> obtenertotListadoLineasInvestigacion(int idSemillero);
    Respuesta<List<LineaInvestigacion>> obtenerListadoLineasInvestigacion();
}
