package edu.unicauca.SivriBackendApp.core.planTrabajo.application.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.application.mapper.CompromisoSemilleroDtoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.CompromisoSemillero;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.CompromisoSemilleroObtenerCU;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("compromisosSemillero")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompromisoSemilleroController {
    private final CompromisoSemilleroObtenerCU compromisoSemilleroObtenerCU;
    private final CompromisoSemilleroDtoMapper compromisoSemilleroDtoMapper;

    public CompromisoSemilleroController(CompromisoSemilleroObtenerCU compromisoSemilleroObtenerCU, CompromisoSemilleroDtoMapper compromisoSemilleroDtoMapper) {
        this.compromisoSemilleroObtenerCU = compromisoSemilleroObtenerCU;
        this.compromisoSemilleroDtoMapper = compromisoSemilleroDtoMapper;
    }

    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerCompromisos(){
        Respuesta respuesta =compromisoSemilleroObtenerCU.obtenerListadoCompromisos();
        respuesta.setData(((List<CompromisoSemillero>) respuesta.getData()).stream().map(compromisoSemilleroDtoMapper::obtenerCompromisos).toList());
        return ResponseEntity.ok().body(respuesta);
    }
}