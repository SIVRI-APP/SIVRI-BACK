package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.aplicacion.ports.in.ProgramaObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Programa;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarProgramas;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("programas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class ProgramaController {
    private final ProgramaObtenerCU programaObtenerCU;


    @GetMapping("/{id}")
    public ResponseEntity<Respuesta<Programa>> obtenerProgramaPorId(@PathVariable(value = "id") int id){
        Respuesta<Programa> respuesta = programaObtenerCU.obtenerPorId(id);
       return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("/obtenerProgramas")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR','FUNCIONARIO:SEMILLEROS','GRUPO:DIRECTOR')")
    public ResponseEntity<Respuesta<List<Programa>>> obtenerListadoProgramas(){
        Respuesta<List<Programa>> respuesta =programaObtenerCU.obtenerProgramas();
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("/obtenerProgramasxdepartamento")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR')")
    public ResponseEntity<Respuesta<List<ListarProgramas>>> obtenerProgramasxdepartamento(
            @RequestParam() Integer semilleroId
    ){
        return ResponseEntity.ok().body(programaObtenerCU.obtenerProgramasxdepatamento(semilleroId));
    }


}
