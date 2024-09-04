package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.ProyectoDetalladoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.ProyectoListarConFiltroProyeccion;
import org.springframework.data.domain.Page;

import java.time.LocalDate;


public interface ProyectoObtenerCU {

    Respuesta<ProyectoDetalladoDTO> obtenerProyectoInformacionDetallada(long proyectoId);

    Respuesta<Page<ProyectoListarConFiltroProyeccion>> listarConFiltro(int pageNo, int pageSize, String id, String nombre, EstadoProyecto estado, LocalDate fechaInicio, LocalDate fechaFin, Integer organismoDeInvestigacionId, TipoFinanciacion tipoFinanciacion);

    Respuesta<Proyecto> obtenerProyecto(long proyectoId);
}
