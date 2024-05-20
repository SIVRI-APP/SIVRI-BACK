package edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.proyecciones.ListarProgramas;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SemilleroProgramaObtenerCU {
    Respuesta<Boolean> existePorId(long id);
    Respuesta<SemilleroPrograma> obtenerPorId(long id);
    Respuesta<Page<ListarProgramas>> obtenerListadoProgramasPorSemilleroId(int pageNo, int pageSize, int idSemillero);

}
