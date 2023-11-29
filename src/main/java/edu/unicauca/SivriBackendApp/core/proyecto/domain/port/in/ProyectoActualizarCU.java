package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;

public interface ProyectoActualizarCU {
    Respuesta<Boolean> actualizar(Proyecto nuevosDatos);

    Respuesta<Boolean> asociarProyectoAconvocaotira(Long idProyecto, Long idConvocatoria);
}
