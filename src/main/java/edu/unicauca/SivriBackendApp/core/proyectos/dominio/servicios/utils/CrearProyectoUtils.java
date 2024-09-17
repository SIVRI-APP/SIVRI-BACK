package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios.utils;

import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.GuardarProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CrearProyectoUtils {

    private final ProyectoCrearREPO proyectoCrearREPO;

    public void guardarProyecto(ProyectoEntity proyecto, GuardarProyectoDTO dto) {

        // Actualizar la información general
        proyecto.setNombre(dto.getInformacionGeneral().getNombre());
        proyecto.setEstado(EstadoProyecto.valueOf(dto.getInformacionGeneral().getEstado()));
        proyecto.setFechaInicio(dto.getInformacionGeneral().getFechaInicio());
        proyecto.setFechaFin(dto.getInformacionGeneral().getFechaFin());
        proyecto.setPlanteamiento(dto.getInformacionGeneral().getPlanteamiento());
        proyecto.setObjetivoGeneral(dto.getInformacionGeneral().getObjetivoGeneral());
        proyecto.setObjetivosEspecificos(dto.getInformacionGeneral().getObjetivosEspecificos());
        proyecto.setJustificacion(dto.getInformacionGeneral().getJustificacion());
        proyecto.setEnfoqueMetodologico(dto.getInformacionGeneral().getEnfoqueMetodologico());
        proyecto.setAspectosEticosLegales(dto.getInformacionGeneral().getAspectosEticosLegales());
        proyecto.setConfidencialidad(dto.getInformacionGeneral().getConfidencialidadDeInformacion());
        proyecto.setEfectosAdversos(dto.getInformacionGeneral().getEfectosAdversos());
        proyecto.setImpacResulEsperados(dto.getInformacionGeneral().getImpactosResultadosEsperados());
        proyecto.setConsideraciones(dto.getInformacionGeneral().getConsideraciones());
        proyecto.setEliminadoLogico(dto.getInformacionGeneral().getEliminadoLogico());

        // Aquí puedes manejar la actualización de otros campos relacionados con `convocatoria`, `integrantes`, `lineasDeInvestigacion`, etc.
        // Ejemplo:
        // proyecto.setConvocatoria(convocatoriaService.actualizarConvocatoria(proyecto.getConvocatoria(), dto.getConvocatoria()));
        // proyecto.setIntegrantes(integranteService.actualizarIntegrantes(proyecto.getIntegrantes(), dto.getIntegrantes()));
        // proyecto.setLineasDeInvestigacion(lineaDeInvestigacionService.actualizarLineas(proyecto.getLineasDeInvestigacion(), dto.getLineasDeInvestigacion()));
        // proyecto.setEnfoquesDiferenciales(enfoqueDiferencialService.actualizarEnfoques(proyecto.getEnfoquesDiferenciales(), dto.getEnfoquesDiferenciales()));

        // Guardar el proyecto actualizado
        proyectoCrearREPO.guardarProyecto(proyecto);
    }
}
