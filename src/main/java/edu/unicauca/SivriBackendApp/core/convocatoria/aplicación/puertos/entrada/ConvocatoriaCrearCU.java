package edu.unicauca.SivriBackendApp.core.convocatoria.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;

public interface ConvocatoriaCrearCU {
    Respuesta<Boolean> crearConvocatoria(Convocatoria convocatoria);
}
