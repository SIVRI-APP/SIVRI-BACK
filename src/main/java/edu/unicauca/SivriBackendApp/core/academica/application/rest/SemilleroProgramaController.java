package edu.unicauca.SivriBackendApp.core.academica.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.application.mapper.SemilleroProgramaDtoMapper;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.SemilleroProgramaCrearCU;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.SemilleroProgramaObtenerCU;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("semillerosProgramas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SemilleroProgramaController {
    private final SemilleroProgramaObtenerCU semilleroProgramaObtenerCU;
    private final SemilleroProgramaCrearCU semilleroProgramaCrearCU;
    private final SemilleroProgramaDtoMapper semilleroProgramaDtoMapper;

    public SemilleroProgramaController(SemilleroProgramaObtenerCU semilleroProgramaObtenerCU, SemilleroProgramaCrearCU semilleroProgramaCrearCU, SemilleroProgramaDtoMapper semilleroProgramaDtoMapper) {
        this.semilleroProgramaObtenerCU = semilleroProgramaObtenerCU;
        this.semilleroProgramaCrearCU = semilleroProgramaCrearCU;
        this.semilleroProgramaDtoMapper = semilleroProgramaDtoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerSemilleroProgramaPorId(@PathVariable(value = "id") long id){
        Respuesta respuesta =semilleroProgramaObtenerCU.obtenerPorId(id);
        respuesta.setData(semilleroProgramaDtoMapper.obtenerProgramasPorSemilleroId((SemilleroPrograma) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/semilleroProgramaPorSemilleroId/{id}")
    public ResponseEntity<Respuesta> obtenerProgramasPorSemilleroId(@PathVariable(value = "id") int idSemillero){
        Respuesta respuesta =semilleroProgramaObtenerCU.obtenerListadoProgramasPorSemilleroId(idSemillero);
        respuesta.setData(((List<SemilleroPrograma>) respuesta.getData()).stream().map(semilleroProgramaDtoMapper::obtenerProgramasPorSemilleroId).toList());
        return ResponseEntity.ok().body(respuesta);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Respuesta> crear(@PathVariable(value = "id") int idSemillero,@Valid @RequestParam("programaId") int idPrograma){
        Respuesta respuesta =semilleroProgramaCrearCU.crear(idSemillero,idPrograma);
        return ResponseEntity.ok().body(respuesta);

    }
}
