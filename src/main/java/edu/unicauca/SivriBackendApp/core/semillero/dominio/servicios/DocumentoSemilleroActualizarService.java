package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.DocumentoSemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.DocumentoSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.DocumentoSemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentoSemilleroActualizarService implements DocumentoSemilleroActualizarCU {

    private final DocumentoSemilleroActualizarREPO documentoSemilleroActualizarREPO;
    private final DocumentoSemilleroObtenerCU documentoSemilleroObtenerCU;

    public DocumentoSemilleroActualizarService(DocumentoSemilleroActualizarREPO documentoSemilleroActualizarREPO, DocumentoSemilleroObtenerCU documentoSemilleroObtenerCU) {
        this.documentoSemilleroActualizarREPO = documentoSemilleroActualizarREPO;
        this.documentoSemilleroObtenerCU = documentoSemilleroObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizar(int idDocumentoSemillero, DocumentoSemillero datos) {

        DocumentoSemillero documentoActualizar= documentoSemilleroObtenerCU.obtenerPorId(idDocumentoSemillero).getData();
        documentoActualizar.setObservacion(datos.getObservacion());
        documentoActualizar.setEstado(datos.getEstado());

        Boolean respuesta= documentoSemilleroActualizarREPO.actualizar(documentoActualizar);
        if (!respuesta) {
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Documento Semillero", "Id", String.valueOf(datos.getId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Documento Semillero"), "", true).getRespuesta();
    }
}
