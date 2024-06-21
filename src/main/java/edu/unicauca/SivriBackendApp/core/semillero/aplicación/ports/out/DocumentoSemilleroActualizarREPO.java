package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;

public interface DocumentoSemilleroActualizarREPO {
    Boolean actualizar(DocumentoSemillero datos);
}
