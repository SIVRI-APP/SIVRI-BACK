package edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.entrada;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.proyecciones.ConvocatoriaInformacionDetalladaProyeccion;

public interface ConvocatoriaObtenerCU {

    Respuesta<ConvocatoriaInformacionDetalladaProyeccion> obtenerConvocatoriaInformacionDetallada(long convocatoriaId);
}
