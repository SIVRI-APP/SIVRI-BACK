package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoDisciplinaActualizarCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoDisciplinaCrearCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoDisciplinaEliminarCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoDisciplinaObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper.GrupoDisciplinaDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gruposDisciplinas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GrupoDisciplinaController {

    private final GrupoDisciplinaObtenerCU grupoDisciplinaObtenerCU;
    private final GrupoDisciplinaCrearCU grupoDisciplinaCrearCU;
    private final GrupoDisciplinaActualizarCU grupoDisciplinaActualizarCU;
    private final GrupoDisciplinaEliminarCU grupoDisciplinaEliminarCU;
    private final GrupoDisciplinaDtoMapper grupoDisciplinaDtoMapper;

    public GrupoDisciplinaController(GrupoDisciplinaObtenerCU grupoDisciplinaObtenerCU, GrupoDisciplinaCrearCU grupoDisciplinaCrearCU, GrupoDisciplinaActualizarCU grupoDisciplinaActualizarCU, GrupoDisciplinaEliminarCU grupoDisciplinaEliminarCU, GrupoDisciplinaDtoMapper grupoDisciplinaDtoMapper) {
        this.grupoDisciplinaObtenerCU = grupoDisciplinaObtenerCU;
        this.grupoDisciplinaCrearCU = grupoDisciplinaCrearCU;
        this.grupoDisciplinaActualizarCU = grupoDisciplinaActualizarCU;
        this.grupoDisciplinaEliminarCU = grupoDisciplinaEliminarCU;
        this.grupoDisciplinaDtoMapper = grupoDisciplinaDtoMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerGrupoDisciplinaPorId(@PathVariable(value = "id") long id){
        Respuesta respuesta =grupoDisciplinaObtenerCU.obtenerPorId(id);
        respuesta.setData(grupoDisciplinaDtoMapper.obtenerDisciplinasPorGrupoId((GrupoDisciplina) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/grupoDisciplinaPorGrupoId/{id}")
    public ResponseEntity<Respuesta> obtenerDisciplinasPorGrupoId(@PathVariable(value = "id") int idGrupo){
        Respuesta respuesta = grupoDisciplinaObtenerCU.obtenerListadoDisciplinasPorGrupoId(idGrupo);
        respuesta.setData(((List<GrupoDisciplina>) respuesta.getData()).stream().map(grupoDisciplinaDtoMapper::obtenerDisciplinasPorGrupoId).toList());
        return ResponseEntity.ok().body(respuesta);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Respuesta> crear(@PathVariable(value = "id") int idGrupo,@Valid @RequestParam("disciplinaId") int idDisciplina){
        Respuesta respuesta = grupoDisciplinaCrearCU.crear(idGrupo,idDisciplina);
        return ResponseEntity.ok().body(respuesta);
    }
    @PatchMapping("/actualizarDisciplina/{id}")
    public ResponseEntity<Respuesta> actualizar(@PathVariable(value = "id") long idGrupoDisciplina,@Valid @RequestParam("disciplinaId") int idDisciplina){
        Respuesta respuesta =grupoDisciplinaActualizarCU.actualizar(idGrupoDisciplina,idDisciplina);
        return ResponseEntity.ok().body(respuesta);
    }
    @DeleteMapping("/eliminarGrupoDisciplina/{id}")
    public ResponseEntity<Respuesta> eliminarDisciplinaDeGrupo(@PathVariable(value = "id") int idGrupoDisciplina){
        Respuesta respuesta =grupoDisciplinaEliminarCU.eliminacionGrupoDisciplinaFisico(idGrupoDisciplina);
        return ResponseEntity.ok().body(respuesta);

    }

}
