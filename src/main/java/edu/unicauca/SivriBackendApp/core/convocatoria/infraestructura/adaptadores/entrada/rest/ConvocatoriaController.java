package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicación.puertos.entrada.ConvocatoriaCrearCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.dto.petición.CrearConvocatoriaDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.mapper.ConvocatoriaRestMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convocatoria")
@AllArgsConstructor
public class ConvocatoriaController {

    private final ConvocatoriaCrearCU convocatoriaCrearCU;
    private final ConvocatoriaRestMapper convocatoriaRestMapper;

    @PostMapping()
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta> crearConvocatoria(@Valid @RequestBody CrearConvocatoriaDTO convocatoria){
        Respuesta respuesta = convocatoriaCrearCU.crearConvocatoria(convocatoriaRestMapper.crearConvocatoria(convocatoria));
        return ResponseEntity.ok().body(respuesta);
    }
}
