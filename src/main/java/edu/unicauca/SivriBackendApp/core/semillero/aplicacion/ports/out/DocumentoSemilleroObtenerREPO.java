package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.DocumentoSemilleroProyeccion;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.VerDoumentoSemillero;

import java.time.LocalDate;
import java.util.Optional;

public interface DocumentoSemilleroObtenerREPO {
    Boolean existePorId(int id);
    Boolean existexSemilleroIdyTipo(Integer semilleroId,TipoDocumentoSemillero tipo);
    Optional<DocumentoSemillero> obtenerPorId(int id);
    Optional<DocumentoSemilleroProyeccion> obtenerDocumentoSemilleroxDocumentoActivo(Integer semilleroId, TipoDocumentoSemillero tipo);
    Optional<VerDoumentoSemillero> obtenerDatosDocumento();
    Integer existeDocumentoxIdSemillero(Integer idSemillero,String tipo);
}
