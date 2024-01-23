package edu.unicauca.SivriBackendApp.core.convocatoria.aplicación.puertos.salida;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;

public interface ConvocatoriaCrearREPO {
    Boolean crearConvocatoria(Convocatoria convocatoria);
}
