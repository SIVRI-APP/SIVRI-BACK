package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.DocumentoSemilleroProyeccion;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.VerDoumentoSemillero;

import java.io.File;

public interface DocumentoSemilleroObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Boolean> existexSemilleroIdytipo(Integer semilleroId, TipoDocumentoSemillero tipo);
    Respuesta<DocumentoSemillero> obtenerPorId(int id);
    Respuesta<DocumentoSemilleroProyeccion> obtenerDocumentoxDocumentoActivo(Integer semilleroId, TipoDocumentoSemillero tipo);
    Respuesta<VerDoumentoSemillero> ObtenerDatosDocumento();
    File obtenerDocumentoSemillero(Integer idSemillero, String tipo) throws Exception;
}
