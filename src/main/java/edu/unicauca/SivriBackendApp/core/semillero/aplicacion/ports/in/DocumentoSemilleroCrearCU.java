package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;

public interface DocumentoSemilleroCrearCU {

    Respuesta<Boolean> subirDocumentoSemillero(Integer idSemillero, TipoDocumentoSemillero tipoDocumento, byte[] file, String nameFile) throws Exception;

}
