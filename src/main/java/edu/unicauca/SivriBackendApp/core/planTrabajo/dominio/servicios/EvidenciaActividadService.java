package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.EvidenciaActividadCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.EvidenciaActividadREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EvidenciaActividad;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class EvidenciaActividadService implements EvidenciaActividadCU {
    private final EvidenciaActividadREPO evidenciaActividadREPO;

    public Respuesta<Boolean> subirEvidenciaActividad(Integer actividadId, MultipartFile archivo) throws Exception {
        if (archivo.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.archivo");
        }
        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = archivo.getBytes();
            String fileOriginalName = archivo.getOriginalFilename();
            long fileSize = archivo.getSize();
            long maxFileSize = 5 * 1024 * 1024;
            if (fileSize > maxFileSize) {
                throw new ReglaDeNegocioException("archivo muy grande");
            }
            if (!fileOriginalName.endsWith(".pdf")) {
                throw new ReglaDeNegocioException("el archivo debe ser .pdf");
            }
            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newFileName = fileName + fileExtension;
            // se crea la carpeta donde se va a guardar las evidencias de las actividades
            File folder = new File("src/main/resources/evidenciaActividad/");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            Path path = Paths.get("src/main/resources/evidenciaActividad/" + newFileName);
            Files.write(path, bytes);
            EvidenciaActividad newEvidencia = new EvidenciaActividad();
            newEvidencia.setActividadId(actividadId);
            newEvidencia.setEvidencia(path.toString());
            Boolean respuesta = evidenciaActividadREPO.subirEvidenciaActividad(newEvidencia);
            if (!respuesta) {
                throw new ReglaDeNegocioException("bad.error.creacion.evidencia");
            }
            return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Evidencia de Actividad "), "", true).getRespuesta();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Respuesta<EvidenciaActividad> obtenerPorId(int id) {
        Optional<EvidenciaActividad> respuestaBd= evidenciaActividadREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Evidencia ", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> subirEvidenciaActividad(Integer actividadId, byte[] bytes, String name) throws Exception {
        Boolean respuesta = false;
        EvidenciaActividad newEvidencia = new EvidenciaActividad();
        if (bytes.length == 0){
            throw new ReglaDeNegocioException("bad.no.se.encontro.archivo");
        }
        try {
            //String fileName = UUID.randomUUID().toString();
            String idactividadName=actividadId.toString();
            String newFileName =idactividadName+name;
            long fileSize = bytes.length;
            long maxFileSize = 5 * 1024 * 1024;
            if (fileSize > maxFileSize) {
                throw new ReglaDeNegocioException("archivo muy grande");
            }
            if (!newFileName.endsWith(".pdf")) {
                throw new ReglaDeNegocioException("el archivo debe ser .pdf");
            }
            // se crea la carpeta donde se va a guardar las evidencias de las actividades
            File folder = new File("src/main/resources/evidenciaActividad/");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            //reviso si en la bd esta el id de la actividad
            Integer existeEvidencia = evidenciaActividadREPO.existexActividadId(actividadId);
            if (existeEvidencia!=0){
                //actualiza el registro
                EvidenciaActividad evidenciaActualizar = obtenerPorId(existeEvidencia).getData();
                //obtengo la url del archivo
                String urlActualizar= evidenciaActualizar.getEvidencia();
                //elimino el archivo
                 File archivoExistente = new File(urlActualizar);
                if (archivoExistente.exists() && archivoExistente.delete()) {
                    System.out.println("Archivo eliminado exitosamente");
                } else {
                    System.out.println("No se pudo eliminar el archivo existente");
                }
                //guardo el otro archivo
                Path path = Paths.get("src/main/resources/evidenciaActividad/" + newFileName);
                Files.write(path, bytes);
                //actualizo la url
                evidenciaActualizar.setEvidencia(path.toString());
                respuesta = evidenciaActividadREPO.subirEvidenciaActividad(evidenciaActualizar);
            }else {
                //crea el registro
                Path path = Paths.get("src/main/resources/evidenciaActividad/" + newFileName);
                System.out.println("path: " + path);
                Files.write(path, bytes);
                newEvidencia.setActividadId(actividadId);
                newEvidencia.setEvidencia(path.toString());
                respuesta = evidenciaActividadREPO.subirEvidenciaActividad(newEvidencia);
            }
            if (!respuesta) {
                throw new ReglaDeNegocioException("bad.error.creacion.evidencia");
            }
            return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Evidencia de Actividad "), "", true).getRespuesta();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Resource obtenerArchivoPorActividadId(Integer actividadId) throws Exception {
        Integer idEvidencia = evidenciaActividadREPO.existexActividadId(actividadId);
        if (idEvidencia != 0){
            EvidenciaActividad evidencia = obtenerPorId(idEvidencia).getData();
            String filePath = evidencia.getEvidencia();
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                Resource resourse= (Resource) new UrlResource(path.toUri());
                System.out.println("resourse "+resourse);
                return resourse;
            } else {
                throw new FileNotFoundException("Archivo no encontrado: " + filePath);
            }
        }else {
            throw new FileNotFoundException("Evidencia no encontrada para la actividad con ID: " + actividadId);
        }

    }
}
