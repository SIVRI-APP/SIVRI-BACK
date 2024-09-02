package edu.unicauca.SivriBackendApp.common.file;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/file")
public class FileController {

    private final StorageService storageService;

    @Autowired
    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("files")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(FileController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));
        System.out.println(model.getAttribute("files"));
        return "uploadForm";
    }

    @GetMapping("files/{organismo}/{organismoId}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(
            @PathVariable String organismo,
            @PathVariable String organismoId,
            @PathVariable String filename) throws IOException {

        // Llama al servicio de almacenamiento para cargar el archivo como un recurso.
        Resource file = storageService.loadAsResource(organismo, organismoId, filename);

        // Verifica si el archivo fue encontrado.
        if (file == null) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si el archivo no se encuentra.
        }

        // Determina el tipo de contenido del archivo.
        String contentType = Files.probeContentType(file.getFile().toPath());

        // Devuelve la respuesta HTTP con el archivo y su tipo de contenido.
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);
    }

    @PostMapping("upload")
    public ResponseEntity<Respuesta<String>> handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("organismo") String organismo,
                                   @RequestParam("organismoId") String organismoId,
                                   @RequestParam("documentoConvocatoriaId") String documentoConvocatoriaId
    )
    {
        Respuesta<String> respuesta = storageService.store(file, organismo, organismoId, documentoConvocatoriaId);

        return ResponseEntity.ok().body(respuesta);
    }

}
