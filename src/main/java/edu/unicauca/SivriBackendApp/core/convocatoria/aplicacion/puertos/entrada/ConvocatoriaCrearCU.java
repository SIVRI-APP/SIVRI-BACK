package edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Checklist;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;

import java.util.List;

public interface ConvocatoriaCrearCU {

    Respuesta<Boolean> crearConvocatoria(Convocatoria convocatoria, List<Checklist> checklists);
}
