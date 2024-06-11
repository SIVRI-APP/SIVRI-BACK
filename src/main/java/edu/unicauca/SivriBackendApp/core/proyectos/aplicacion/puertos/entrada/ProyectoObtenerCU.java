package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.proyecciones.ProyectoInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.proyecciones.ProyectoListarConFiltroProyeccion;
import org.springframework.data.domain.Page;

public interface ProyectoObtenerCU {

    Respuesta<ProyectoInformacionDetalladaProyeccion> obtenerProyectoInformacionDetallada(long proyectoId);

    Respuesta<Page<ProyectoListarConFiltroProyeccion>> listarConFiltro(int pageNo, int pageSize, String id, String nombre);
}
