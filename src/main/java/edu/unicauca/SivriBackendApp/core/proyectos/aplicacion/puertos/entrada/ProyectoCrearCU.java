package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.CrearProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.GuardarProyectoDTO;


public interface ProyectoCrearCU {

    Respuesta<Boolean> crearProyecto(CrearProyectoDTO proyecto);

    Respuesta<Boolean> formalizarProyecto(Proyecto proyecto);

    Respuesta<Boolean> guardarProyecto(GuardarProyectoDTO proyecto);

    Respuesta<Boolean> asociarConvocatoria(long proyectoId, long convocatoriaId);

    Respuesta<Boolean> agregarIntegrante(Long proyectoId, Long usuarioId, RolProyectoEnum rolId);
}
