package edu.unicauca.SivriBackendApp.common.file;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;


public interface StorageService {

    void init();

    Respuesta<String> store(MultipartFile file, String organismo, String organismoId, String documentoConvocatoriaId);

    Stream<Path> loadAll();

    Resource loadAsResource(String filename, String organismo, String organismoId);

}
