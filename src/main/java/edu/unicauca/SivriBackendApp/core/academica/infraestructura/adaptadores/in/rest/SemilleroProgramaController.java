package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in.SemilleroProgramaActualizarCU;
import edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in.SemilleroProgramaCrearCU;
import edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in.SemilleroProgramaEliminarCU;
import edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in.SemilleroProgramaObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.mapper.SemilleroProgramaDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("semillerosProgramas")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class SemilleroProgramaController {
    private final SemilleroProgramaObtenerCU semilleroProgramaObtenerCU;
    private final SemilleroProgramaCrearCU semilleroProgramaCrearCU;
    private final SemilleroProgramaActualizarCU semilleroProgramaActualizarCU;
    private final SemilleroProgramaEliminarCU semilleroProgramaEliminarCU;
    private final SemilleroProgramaDtoMapper semilleroProgramaDtoMapper;

    public SemilleroProgramaController(SemilleroProgramaObtenerCU semilleroProgramaObtenerCU, SemilleroProgramaCrearCU semilleroProgramaCrearCU, SemilleroProgramaActualizarCU semilleroProgramaActualizarCU, SemilleroProgramaEliminarCU semilleroProgramaEliminarCU, SemilleroProgramaDtoMapper semilleroProgramaDtoMapper) {
        this.semilleroProgramaObtenerCU = semilleroProgramaObtenerCU;
        this.semilleroProgramaCrearCU = semilleroProgramaCrearCU;
        this.semilleroProgramaActualizarCU = semilleroProgramaActualizarCU;
        this.semilleroProgramaEliminarCU = semilleroProgramaEliminarCU;
        this.semilleroProgramaDtoMapper = semilleroProgramaDtoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerSemilleroProgramaPorId(@PathVariable(value = "id") long id){
        Respuesta respuesta =semilleroProgramaObtenerCU.obtenerPorId(id);
        respuesta.setData(semilleroProgramaDtoMapper.obtenerProgramasPorSemilleroId((SemilleroPrograma) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/obtenerProgramasPorSemilleroId")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR', " +
            "'SEMILLERO:MENTOR',  " +
            "'FUNCIONARIO:SEMILLEROS')")
    public ResponseEntity<Respuesta> obtenerProgramasPorSemilleroIdPaginado(
            @RequestParam(value = "semilleroId",required = true) int idSemillero,
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        Respuesta respuesta =semilleroProgramaObtenerCU.obtenerListadoProgramasPorSemilleroId(pageNo,pageSize,idSemillero);
        return ResponseEntity.ok().body(respuesta);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Respuesta> crear(@PathVariable(value = "id") int idSemillero,@Valid @RequestParam("programaId") int idPrograma){
        Respuesta respuesta =semilleroProgramaCrearCU.crear(idSemillero,idPrograma);
        return ResponseEntity.ok().body(respuesta);

    }
    @PatchMapping("/{id}")
    public ResponseEntity<Respuesta> actualizar(@PathVariable(value = "id") long idSemilleroPrograma,@Valid @RequestParam("programaId") int idPrograma){
        Respuesta respuesta =semilleroProgramaActualizarCU.actualizar(idSemilleroPrograma,idPrograma);
        return ResponseEntity.ok().body(respuesta);

    }
    @DeleteMapping("/eliminarSemilleroPrograma/{id}")
    public ResponseEntity<Respuesta> eliminarLinea(@PathVariable(value = "id") int idSemilleroPrograma){
        Respuesta respuesta =semilleroProgramaEliminarCU.eliminacionSemilleroProgramaFisico(idSemilleroPrograma);
        return ResponseEntity.ok().body(respuesta);

    }

}
