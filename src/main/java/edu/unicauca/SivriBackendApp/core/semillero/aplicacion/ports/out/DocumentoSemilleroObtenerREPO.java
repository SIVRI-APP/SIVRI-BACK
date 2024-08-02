package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.VerDoumentoSemillero;

import java.util.Optional;

public interface DocumentoSemilleroObtenerREPO {
    Boolean existePorId(int id);
    Optional<DocumentoSemillero> obtenerPorId(int id);
    Optional<VerDoumentoSemillero> obtenerDatosDocumento();
}
