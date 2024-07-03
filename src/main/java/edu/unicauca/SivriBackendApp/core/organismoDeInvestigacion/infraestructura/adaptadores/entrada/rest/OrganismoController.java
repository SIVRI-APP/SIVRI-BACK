package edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.aplicacion.puertos.entrada.OrganismoObtenerCU;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ListarOrganismosParaAsociarProyectoProyeccion;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/organismo")
@AllArgsConstructor
public class OrganismoController {

    /**
     * Adaptadores
     */
    private final OrganismoObtenerCU organismoObtenerCU;

    @GetMapping("listarTodoConFiltro")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'PROYECTO:DIRECTOR')")
    public ResponseEntity<Respuesta<Page<ListarOrganismosParaAsociarProyectoProyeccion>>> listarTodoConFiltro(
            @RequestParam String tipoOrganismo,
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String nombre,
            @RequestParam @Min(value = 0, message = "El valor de pageNo debe ser positivo") int pageNo,
            @RequestParam @Min(value = 0, message = "El valor de pageSize debe ser positivo") int pageSize
    ) {
        Respuesta<Page<ListarOrganismosParaAsociarProyectoProyeccion>> respuesta = organismoObtenerCU.listarConFiltro(
                pageNo,
                pageSize,
                tipoOrganismo,
                id,
                nombre
        );
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("listarIntegrantesDocenteOrganismo")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'PROYECTO:DIRECTOR')")
    public ResponseEntity<Respuesta<Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion>>> listarIntegrantesDocenteOrganismo(
            @RequestParam Integer organismoId
    ) {
        Respuesta<Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion>> respuesta = organismoObtenerCU.listarIntegrantesDocenteOrganismo(organismoId);

        return ResponseEntity.ok().body(respuesta);
    }
}
