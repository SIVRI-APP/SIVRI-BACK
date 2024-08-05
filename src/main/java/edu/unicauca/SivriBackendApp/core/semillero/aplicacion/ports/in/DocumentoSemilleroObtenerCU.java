package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.VerDoumentoSemillero;

import java.io.File;

public interface DocumentoSemilleroObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<DocumentoSemillero> obtenerPorId(int id);
    Respuesta<VerDoumentoSemillero> ObtenerDatosDocumento();
    File obtenerDocumentoSemillero(Integer idSemillero, String tipo) throws Exception;
}
