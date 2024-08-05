package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;

public interface DocumentoSemilleroCrearREPO {
    Boolean subirDocumentoSemillero(DocumentoSemillero nuevoDocumento);
}
