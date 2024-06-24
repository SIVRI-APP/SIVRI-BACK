package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarProgramas;
import org.springframework.data.domain.Page;

public interface SemilleroProgramaObtenerCU {
    Respuesta<Boolean> existePorId(long id);
    Respuesta<SemilleroPrograma> obtenerPorId(long id);
    Respuesta<Page<ListarProgramas>> obtenerListadoProgramasPorSemilleroId(int pageNo, int pageSize, int idSemillero);

}
