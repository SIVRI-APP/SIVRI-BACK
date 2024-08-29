package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.DocumentoSemilleroEntity;

import java.time.LocalDate;
import java.util.Optional;

public interface DocumentoSemilleroCrearREPO {
    Boolean subirDocumentoSemillero(DocumentoSemillero nuevoDocumento);

    Optional<DocumentoSemillero> obtenerIdDocumento(int semilleroId,TipoDocumentoSemillero tipo);
    DocumentoSemillero obtDocuemntoxId(Semillero semillero, LocalDate fechaRegistro, TipoDocumentoSemillero tipo);
    Boolean eliminaDocuemnto(DocumentoSemillero documento);
   // Optional<DocumentoSemillero> findByFechaRegistroAndTipo(LocalDate fechaRegistro, TipoDocumentoSemillero tipo);
}
