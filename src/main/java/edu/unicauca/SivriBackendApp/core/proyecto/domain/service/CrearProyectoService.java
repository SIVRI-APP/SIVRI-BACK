package edu.unicauca.SivriBackendApp.core.proyecto.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.CrearProyectoCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out.CrearProyectoREPO;
import org.springframework.stereotype.Component;

@Component
public class CrearProyectoService implements CrearProyectoCU {

    private CrearProyectoREPO crearProyectoREPO;

    public CrearProyectoService(CrearProyectoREPO crearProyectoREPO) {
        this.crearProyectoREPO = crearProyectoREPO;
    }

    @Override
    public Respuesta<Boolean> crearProyecto(Proyecto proyecto) {
        proyecto.setEstado(EstadoProyecto.FORMULADO);
        Boolean respuesta = crearProyectoREPO.crearProyecto(proyecto);

        if (!respuesta){
            throw new ReglaDeNegocioException("Error al crear proyecto: " + proyecto.getNombre());
        }

        return new RespuestaHandler<>(201, "Proyecto creado Exitosamente", "", respuesta).getRespuesta();
    }
}
