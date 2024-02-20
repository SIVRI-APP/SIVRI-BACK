package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.DocumentoSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.DocumentoSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.VerDoumentoSemillero;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DocumentoSemilleroObtenerService implements DocumentoSemilleroObtenerCU {

    private final DocumentoSemilleroObtenerREPO documentoSemilleroObtenerREPO;

    public DocumentoSemilleroObtenerService(DocumentoSemilleroObtenerREPO documentoSemilleroObtenerREPO) {
        this.documentoSemilleroObtenerREPO = documentoSemilleroObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=documentoSemilleroObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Documento Semillero", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<DocumentoSemillero> obtenerPorId(int id) {
        Optional<DocumentoSemillero> respuestaBd= documentoSemilleroObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Documento Semillero", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<VerDoumentoSemillero> ObtenerDatosDocumento() {
        Optional<VerDoumentoSemillero> respuesta=documentoSemilleroObtenerREPO.obtenerDatosDocumento();

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "Exitoso", respuesta.get()).getRespuesta();
    }
}
