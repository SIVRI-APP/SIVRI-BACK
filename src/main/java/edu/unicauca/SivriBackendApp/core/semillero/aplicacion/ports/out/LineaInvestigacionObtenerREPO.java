package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;


import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarLineasInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.LineaInvestigacionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LineaInvestigacionObtenerREPO {
    Boolean existePorId(int id);
    Optional<LineaInvestigacion> obtenerPorId(int id);
    Page<List<ListarLineasInvestigacion>> obtenerLineasInvestigacionPorSemilleroId(Pageable pageable, int idSemillero);
    List<LineaInvestigacion> obtenertotListadoLineasInvestigacion(int idSemillero);
    List<LineaInvestigacion> obtenerListadoLineasInvestigacion();
}
