package edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.proyecciones.ConvocatoriaInformacionDetalladaProyeccion;

import java.util.Optional;

public interface ConvocatoriaObtenerREPO {

    Optional<ConvocatoriaInformacionDetalladaProyeccion> obtenerConvocatoriaInformacionDetallada (long convocatoriaId);
}
