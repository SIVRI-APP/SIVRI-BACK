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
    public Respuesta<String> store(MultipartFile file, String organismo, String organismoId, String documentoConvocatoriaId) {
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

            // Construir la ruta del subdirectorio usando los parámetros "organismo" y "organismoId".
            Path directoryPath = this.rootLocation
                    .resolve(Paths.get(organismo))   // Primer subdirectorio basado en "organismo".
                    .resolve(Paths.get(organismoId)) // Segundo subdirectorio basado en "organismoId".
                    .normalize().toAbsolutePath();

            // Crear los subdirectorios si no existen.
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath); // Crea los directorios necesarios para la ruta si no existen.
            }

            // Alamacenar el registor en base de datos
            EvidenciaProyectoDocumentoConvocatoriaEntity evidencia = proyectoCargarArchivo.cargarDocumentoConvocatoria(filename, organismoId, documentoConvocatoriaId).getData();

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
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        }
        catch (IOException e) {
            throw new ReglaDeNegocioException("bad.location5", List.of(e.getMessage()));
        }

    }

    private Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String organismo, String organismoId, String filename) {
        try {
            // Construye la ruta completa del archivo.
            Path filePath = this.rootLocation
                    .resolve(Paths.get(organismo))
                    .resolve(Paths.get(organismoId))
                    .resolve(Paths.get(filename))
                    .normalize()
                    .toAbsolutePath();

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
