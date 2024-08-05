package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.DocumentoSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.DocumentoSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class DocumentoSemilleroCrearService implements DocumentoSemilleroCrearCU {
    private final DocumentoSemilleroCrearREPO documentoSemilleroCrearREPO;
    private final SemilleroObtenerCU semilleroObtenerCU;

    private String guardarArchivo(Integer idSemillero, byte[] bytes, String name) throws IOException {

        String newFileName= idSemillero.toString()+"_"+name;
        long fileSize = bytes.length;
        long maxFileSize = 5 * 1024 * 1024;
        if (fileSize > maxFileSize) {
            throw new ReglaDeNegocioException("archivo muy grande");
        }
        if (!newFileName.endsWith(".pdf")) {
            throw new ReglaDeNegocioException("el archivo debe ser .pdf");
        }
        // se crea la carpeta donde se va a guardar los documentos de los semilleros
        File folder = new File("src/main/resources/documentosSemilleros/");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        //guardo el otro archivo
        Path path = Paths.get("src/main/resources/documentosSemilleros/" + newFileName);
        Files.write(path, bytes);

        return path.toString();
    }

    @Override
    public Respuesta<Boolean> subirDocumentoSemillero(Integer idSemillero, TipoDocumentoSemillero tipoDocumento, byte[] file, String nameFile) throws Exception {
        Boolean respuesta = false;
        String newFileName ="";
        DocumentoSemillero newDocumentoSemillero = new DocumentoSemillero();
        Semillero semillero= new Semillero();
        semilleroObtenerCU.existePorId(idSemillero);
        semillero=semilleroObtenerCU.obtenerSemilleroPorId(idSemillero).getData();
        if (file.length == 0){
            throw new ReglaDeNegocioException("bad.no.se.encontro.archivo");
        }
        try {
            String idSemilleroName= idSemillero.toString();
            if (tipoDocumento.equals(TipoDocumentoSemillero.AVAL_DEPARTAMENTO) ){
                //asigna en el nombre el aval
                newFileName= idSemilleroName+"_aval_"+nameFile;
            } else if (tipoDocumento == TipoDocumentoSemillero.OTROS) {
                newFileName= idSemilleroName+"_otro_"+nameFile;
            }
            long fileSize = file.length;
            long maxFileSize = 5 * 1024 * 1024;
            if (fileSize > maxFileSize) {
                throw new ReglaDeNegocioException("archivo muy grande");
            }
            if (!newFileName.endsWith(".pdf")) {
                throw new ReglaDeNegocioException("el archivo debe ser .pdf");
            }
            // se crea la carpeta donde se va a guardar las evidencias de las actividades
            File folder = new File("src/main/resources/documentos/");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            Path path= Paths.get("src/main/resources/documentos/"+newFileName);
            Files.write(path,file);
            newDocumentoSemillero.setTipo(tipoDocumento);
            newDocumentoSemillero.setEstado(EstadoDocumentoSemillero.REVISION);
            newDocumentoSemillero.setRutaDocumento(path.toString());
            newDocumentoSemillero.setFechaRegistro(LocalDate.now());
            newDocumentoSemillero.setSemillero(semillero);
            respuesta= documentoSemilleroCrearREPO.subirDocumentoSemillero(newDocumentoSemillero);
            if (!respuesta) {
                throw new ReglaDeNegocioException("bad.error.creacion.evidencia");
            }
            return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Docuemnto "), "", true).getRespuesta();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
