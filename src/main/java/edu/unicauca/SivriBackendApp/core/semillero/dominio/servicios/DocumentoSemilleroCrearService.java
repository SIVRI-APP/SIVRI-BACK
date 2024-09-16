package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.DocumentoSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.DocumentoSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.DocumentoSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.DocumentoSemilleroProyeccion;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class DocumentoSemilleroCrearService implements DocumentoSemilleroCrearCU {
    private final DocumentoSemilleroCrearREPO documentoSemilleroCrearREPO;
    private final DocumentoSemilleroObtenerCU documentoSemilleroObtenerCU;
    private final SemilleroObtenerCU semilleroObtenerCU;

    private String guardarArchivo(byte[] filesBytes, String name) throws IOException {

        long fileSize = filesBytes.length;
        long maxFileSize = 5 * 1024 * 1024;
        if (filesBytes.length == 0){
            throw new ReglaDeNegocioException("bad.no.se.encontro.archivo");
        }
        if (fileSize > maxFileSize) {
            throw new ReglaDeNegocioException("archivo muy grande");
        }
        if (!name.endsWith(".pdf")) {
            throw new ReglaDeNegocioException("el archivo debe ser .pdf");
        }
        // se crea la carpeta donde se va a guardar los documentos de los semilleros
        File folder = new File("src/main/resources/documentosSemilleros/");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        //guardo el otro archivo
        Path path = Paths.get("src/main/resources/documentosSemilleros/" + name);
        Files.write(path, filesBytes);

        return path.toString();
    }

    @Override
    public Respuesta<Boolean> subirDocumentoSemillero(Integer idSemillero, TipoDocumentoSemillero tipoDocumento, byte[] file, String nameFile) throws Exception {
        Boolean respuesta = false;
        String newFileName ="";
        Boolean existeDocumentoSemillero= documentoSemilleroObtenerCU.existexSemilleroIdytipo(idSemillero,tipoDocumento).getData();
        DocumentoSemillero newDocumentoSemillero = new DocumentoSemillero();
        Semillero semillero= new Semillero();
        semilleroObtenerCU.existePorId(idSemillero);
        semillero=semilleroObtenerCU.obtenerSemilleroPorId(idSemillero).getData();
        try {
            String idSemilleroName= idSemillero.toString();
            if (tipoDocumento.equals(TipoDocumentoSemillero.AVAL_DEPARTAMENTO) ){
                //asigna en el nombre el aval
                newFileName= idSemilleroName+"_aval_"+nameFile;
            } else if (tipoDocumento == TipoDocumentoSemillero.OTROS) {
                newFileName= idSemilleroName+"_otro_"+nameFile;
            }
            String path=guardarArchivo(file,newFileName);

            //si el documento existe en la bd traer su informacion
            if(existeDocumentoSemillero){
                Respuesta<DocumentoSemilleroProyeccion> documentoSemilleroExiste = documentoSemilleroObtenerCU.obtenerDocumentoxDocumentoActivo(idSemillero,tipoDocumento);
                //busco por id
                DocumentoSemillero obtenerDocumentoExistente = documentoSemilleroObtenerCU.obtenerPorId(documentoSemilleroExiste.getData().getId()).getData();

                if(obtenerDocumentoExistente.getFechaRegistro().equals(LocalDate.now())){
                    //elimino el anterior documento
                    Files.delete(Path.of(obtenerDocumentoExistente.getRutaDocumento()));
                    //actualizo el path
                    obtenerDocumentoExistente.setRutaDocumento(path);
                    //guardo el registro en la bd
                    respuesta = documentoSemilleroCrearREPO.subirDocumentoSemillero(obtenerDocumentoExistente);
                }else {
                    //actualiza el anterior documento con documentoActivo en 0 para saber que se cambio el documento del semillero
                    obtenerDocumentoExistente.setDocumentoActivo(false);
                    documentoSemilleroCrearREPO.subirDocumentoSemillero(obtenerDocumentoExistente);
                    //crea un nuevo registro del documento
                    newDocumentoSemillero.setTipo(tipoDocumento);
                    newDocumentoSemillero.setEstado(EstadoDocumentoSemillero.REVISION);
                    newDocumentoSemillero.setRutaDocumento(path);
                    newDocumentoSemillero.setFechaRegistro(LocalDate.now());
                    newDocumentoSemillero.setSemillero(semillero);
                    newDocumentoSemillero.setDocumentoActivo(true);
                    //guarda en la bd
                    respuesta = documentoSemilleroCrearREPO.subirDocumentoSemillero(newDocumentoSemillero);
                }
            }else {
                //crea un nuevo registro del documento
                newDocumentoSemillero.setTipo(tipoDocumento);
                newDocumentoSemillero.setEstado(EstadoDocumentoSemillero.REVISION);
                newDocumentoSemillero.setRutaDocumento(path);
                newDocumentoSemillero.setFechaRegistro(LocalDate.now());
                newDocumentoSemillero.setSemillero(semillero);
                newDocumentoSemillero.setDocumentoActivo(true);
                //guarda en la bd
                respuesta = documentoSemilleroCrearREPO.subirDocumentoSemillero(newDocumentoSemillero);
            }

            if (!respuesta) {
                Files.delete(Path.of(path));
                throw new ReglaDeNegocioException("bad.error.creacion.evidencia");
            }
            return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Documento "), "", true).getRespuesta();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
