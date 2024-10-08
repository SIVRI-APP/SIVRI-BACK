package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ListarOrganismosParaAsociarProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.RolObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.RolProyectoListarProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rol-proyecto")
@AllArgsConstructor
public class RolProyectoController {

    private RolObtenerCU rolObtenerCU;

    @GetMapping("listarRoles")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'PROYECTO:DIRECTOR')")
    public ResponseEntity<Respuesta<List<RolProyectoListarProyeccion>>> listarRoles(
            @RequestParam() TipoUsuario tipoUsuario,
            @RequestParam() long proyectoId
    ) {
        Respuesta<List<RolProyectoListarProyeccion>> respuesta = rolObtenerCU.retornarRoles(tipoUsuario, proyectoId);
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("obtenesRolesParaAsignarRolProyecto")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'PROYECTO:DIRECTOR')")
    public ResponseEntity<Respuesta<List<RolProyecto>>> obtenesRolesParaAsignarRolProyecto(
            @RequestParam() int usuarioId,
            @RequestParam() long proyectoId
    ) {
        Respuesta<List<RolProyecto>> respuesta = rolObtenerCU.obtenesRolesParaAsignarRolProyecto(usuarioId, proyectoId);
        return ResponseEntity.ok().body(respuesta);
    }
}
