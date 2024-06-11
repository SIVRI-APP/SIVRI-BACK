package edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaListarConFiltroProyeccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ConvocatoriaObtenerREPO {

    Optional<ConvocatoriaInformacionDetalladaProyeccion> obtenerConvocatoriaInformacionDetallada (long convocatoriaId);

    Page<ConvocatoriaListarConFiltroProyeccion> listarConFiltro(Pageable page, String id, String nombre, ConvocatoriaEstado estado, TipoFinanciacion tipoFinanciacion);
}
