package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.DocumentoSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.DocumentoSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.DocumentoSemilleroProyeccion;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.VerDoumentoSemillero;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class DocumentoSemilleroObtenerService implements DocumentoSemilleroObtenerCU {

    private final DocumentoSemilleroObtenerREPO documentoSemilleroObtenerREPO;

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=documentoSemilleroObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Documento Semillero", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> existexSemilleroIdytipo(Integer semilleroId, TipoDocumentoSemillero tipo) {
        Boolean respuesta= documentoSemilleroObtenerREPO.existexSemilleroIdyTipo(semilleroId, tipo);
        if (!respuesta){
            return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",false).getRespuesta();
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
    public Respuesta<DocumentoSemilleroProyeccion> obtenerDocumentoxDocumentoActivo(Integer semilleroId, TipoDocumentoSemillero tipo) {

        Optional<DocumentoSemilleroProyeccion> respuesta=documentoSemilleroObtenerREPO.obtenerDocumentoSemilleroxDocumentoActivo(semilleroId,tipo);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.documento.semillero",List.of("Documento semillero","ID",String.valueOf(semilleroId)));
        }
        return new RespuestaHandler<>(200,"sucess.docuemnto.semillero.encontrado","",respuesta.get()).getRespuesta();
    }

    @Override
    public Respuesta<VerDoumentoSemillero> ObtenerDatosDocumento() {
        Optional<VerDoumentoSemillero> respuesta=documentoSemilleroObtenerREPO.obtenerDatosDocumento();

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "Exitoso", respuesta.get()).getRespuesta();
    }

    @Override
    public File obtenerDocumentoSemillero(Integer idSemillero, String tipo) throws Exception {
        Integer idDocumento = documentoSemilleroObtenerREPO.existeDocumentoxIdSemillero(idSemillero,tipo);
        if (idDocumento!=0){
            DocumentoSemillero documento= obtenerPorId(idDocumento).getData();
            String filePath= documento.getRutaDocumento();
            File archivoObtenido= new File(filePath);
            if (archivoObtenido.exists()){
                return archivoObtenido;
            }else {
                throw new FileNotFoundException("Archivo no encontrado: " + filePath);
            }
        }else {
            throw new FileNotFoundException("Documento no encontrado para el semillero con ID: " + idSemillero);
        }

    }
}
