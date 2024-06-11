package edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.entrada;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaListarConFiltroProyeccion;
import org.springframework.data.domain.Page;

public interface ConvocatoriaObtenerCU {

    Respuesta<ConvocatoriaInformacionDetalladaProyeccion> obtenerConvocatoriaInformacionDetallada(long convocatoriaId);

    Respuesta<Page<ConvocatoriaListarConFiltroProyeccion>> listarConFiltro(int pageNo, int pageSize, String id, String nombre, ConvocatoriaEstado estado, TipoFinanciacion tipoFinanciacion);
}
