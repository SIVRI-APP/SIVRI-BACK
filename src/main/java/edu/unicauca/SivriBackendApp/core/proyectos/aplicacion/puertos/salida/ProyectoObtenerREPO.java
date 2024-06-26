package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.proyecciones.ProyectoInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.proyecciones.ProyectoListarConFiltroProyeccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;

public interface ProyectoObtenerREPO {

    Optional<ProyectoInformacionDetalladaProyeccion> obtenerProyectoInformacionDetallada (long proyectoId);

    Page<ProyectoListarConFiltroProyeccion> listarConFiltro(Pageable page, String id, String nombre, EstadoProyecto estado, LocalDate fechaInicio, LocalDate fechaFin, Integer organismoDeInvestigacionId, TipoFinanciacion tipoFinanciacion, Long usuarioAutenticadoId);

    Optional<Proyecto> obtenerProyecto (long proyectoId);
}
