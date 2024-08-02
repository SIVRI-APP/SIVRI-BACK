package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;

public interface DocumentoSemilleroActualizarCU {
    Respuesta<Boolean> actualizar(int idDocumentoSemillero, DocumentoSemillero datos);
}
