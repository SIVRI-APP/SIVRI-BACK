package edu.unicauca.SivriBackendApp.common.file;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios.ProyectoCargarArchivo;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.EvidenciaCompromisoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.EvidenciaProyectoDocumentoConvocatoriaEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService{

    @Value("${media.location}")
    private String mediaLocation;

    private Path rootLocation;

    @Autowired
    private ProyectoCargarArchivo proyectoCargarArchivo;

    @Override
    public Respuesta<String> store(MultipartFile file, String tipoDeOrganismo, String organismoId, String documentoId, String tablaBd) {
        try {
            // Verifica si el archivo está vacío.
            if (file.isEmpty()) {
                throw new ReglaDeNegocioException("bad.location2"); // Lanza excepción si el archivo está vacío.
            }

            // Obtener el nombre del archivo original proporcionado por el cliente.
            String filename = file.getOriginalFilename();

            // Validar el nombre del archivo para evitar ataques de path traversal
            if (filename == null || filename.contains("..")) {
                throw new ReglaDeNegocioException("Nombre de archivo inválido"); // Lanza excepción si el nombre del archivo es inseguro.
            }

            // Variable para Construir la ruta del subdirectorio usando los parámetros "organismo" y "organismoId" y "tablaBd".
            Path directoryPath = switch (tablaBd) {
                case "ProyectoDocumentoConvocatoria" -> {
                    EvidenciaProyectoDocumentoConvocatoriaEntity evidencia = proyectoCargarArchivo.cargarDocumentoConvocatoria(filename, organismoId, documentoId).getData(); // Alamacenar el registro en base de datos
                    filename =  evidencia.getId() + "-" + file.getOriginalFilename();
                    yield this.rootLocation
                            .resolve(Paths.get(tipoDeOrganismo))                // Primer subdirectorio basado en "organismo".
                            .resolve(Paths.get(organismoId))                    // Segundo subdirectorio basado en "organismoId".
                            .resolve(Paths.get("DocumentosConvocatoria"))  // Tercer subdirectorio basado en "DocumentosConvocatoria".
                            .normalize().toAbsolutePath();
                }
                case "ProyectoDocumentoCompromiso" -> {
                    EvidenciaCompromisoEntity evidencia = proyectoCargarArchivo.cargarDocumentoCompromiso(filename, organismoId, documentoId).getData(); // Alamacenar el registor en base de datos
                    filename =  evidencia.getId() + "-" + file.getOriginalFilename();
                    yield this.rootLocation
                            .resolve(Paths.get(tipoDeOrganismo))                // Primer subdirectorio basado en "organismo".
                            .resolve(Paths.get(organismoId))                    // Segundo subdirectorio basado en "organismoId".
                            .resolve(Paths.get("DocumentosCompromiso"))    // Tercer subdirectorio basado en "DocumentosConvocatoria".
                            .normalize().toAbsolutePath();
                }
                default -> throw new ReglaDeNegocioException("bad.location9", List.of(tablaBd));
            };


            // Crear los subdirectorios si no existen.
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath); // Crea los directorios necesarios para la ruta si no existen.
            }

            // Construir la ruta completa donde se guardará el archivo dentro de los subdirectorios "organismo/organismoId".
            Path destinationFile = directoryPath.resolve(Paths.get(filename)).normalize().toAbsolutePath();

            // Verifica que la ruta de destino esté dentro del directorio raíz permitido.
            if (!destinationFile.getParent().equals(directoryPath)) {
                throw new ReglaDeNegocioException("bad.location3"); // Lanza excepción si el destino no es seguro.
            }

            // Intentar abrir el flujo de entrada desde el archivo cargado para copiar su contenido.
            try (InputStream inputStream = file.getInputStream()) {
                // Copia el contenido del archivo cargado a la ruta de destino, reemplazando cualquier archivo existente.
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

            return new RespuestaHandler<>(200, "ok.documentoCargado", List.of(filename), "", filename).getRespuesta();

        } catch (IOException e) {
            // Captura cualquier excepción de entrada/salida que ocurra durante el proceso de guardado.
            // Lanza una excepción personalizada con un mensaje específico y los detalles del error.
            throw new ReglaDeNegocioException("bad.location4", List.of(e.getMessage()));
        }
    }


    @Override
    public Resource loadAsResource(String filename, String tipoDeOrganismo, String organismoId, String tablaBd) {
        try {
            // Variable para Construir la ruta del subdirectorio usando los parámetros "organismo" y "organismoId" y "tablaBd".
            Path filePath = switch (tablaBd) {
                case "ProyectoDocumentoConvocatoria" -> this.rootLocation
                        .resolve(Paths.get(tipoDeOrganismo))                // Primer subdirectorio basado en "organismo".
                        .resolve(Paths.get(organismoId))                    // Segundo subdirectorio basado en "organismoId".
                        .resolve(Paths.get("DocumentosConvocatoria"))  // Tercer subdirectorio basado en "DocumentosConvocatoria".
                        .resolve(Paths.get(filename))                       // Archivo
                        .normalize().toAbsolutePath();
                case "ProyectoDocumentoCompromiso" -> this.rootLocation
                        .resolve(Paths.get(tipoDeOrganismo))                // Primer subdirectorio basado en "organismo".
                        .resolve(Paths.get(organismoId))                    // Segundo subdirectorio basado en "organismoId".
                        .resolve(Paths.get("DocumentosCompromiso"))    // Tercer subdirectorio basado en "DocumentosConvocatoria".
                        .resolve(Paths.get(filename))                       // Archivo
                        .normalize().toAbsolutePath();
                default -> throw new ReglaDeNegocioException("bad.location9", List.of(tablaBd));
            };

            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new ReglaDeNegocioException("bad.location6", List.of(filename));
            }
        }
        catch (MalformedURLException e) {
            throw new ReglaDeNegocioException("bad.location7", List.of(filename, e.getMessage()));
        }
    }

    @Override
    @PostConstruct
    public void init() {
        try {
            this.rootLocation = Paths.get(this.mediaLocation);

            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new ReglaDeNegocioException("bad.location8", List.of(e.getMessage()));
        }
    }

}
