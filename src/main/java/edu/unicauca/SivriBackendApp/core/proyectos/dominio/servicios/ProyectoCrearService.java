package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.ProyectoCrearCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProyectoCrearService implements ProyectoCrearCU {

    /**
     * Validadores
     */


    /**
     * Adaptadores
     */
    private final ProyectoCrearREPO proyectoCrearREPO;

    @Override
    public Respuesta<Boolean> crearProyecto(Proyecto proyecto) {

        // Validaciones

        // Persistir Proyecto
        Proyecto nuevoProyecto = proyectoCrearREPO.crearProyecto(proyecto);

        // Persistir lo demás

        return new RespuestaHandler<>(200, "ok.ProyectoCreado", List.of(proyecto.getNombre()), "", true).getRespuesta();
    }
}
