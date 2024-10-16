package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios.validadores;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificacionDeUsuario;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio.ConvocatoriaRepository;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.GuardarProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.ProyectoInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.ProyectoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ProyectoValidators {

    private final ProyectoRepository proyectoRepository;
    private final ConvocatoriaRepository convocatoriaRepository;

    private final ProyectoInfraMapper proyectoInfraMapper;

    private final ServicioDeIdentificacionDeUsuario servicioDeIdentificacionDeUsuario;

    public void validarCreacionDeProyecto(String nombreProyecto){
        // EL nombre no existe
        if (proyectoRepository.existsByNombre(nombreProyecto)){
            throw new ReglaDeNegocioException("bad.proyectoYaExiste", List.of(nombreProyecto));
        }

    }

    public void validarFormalizarProyecto(Proyecto proyecto){
        Optional<ProyectoEntity> proyectoEntity = proyectoRepository.findById(proyecto.getId());

        // El proyecto debe Existir
        if (proyectoEntity.isEmpty()){
            throw new ReglaDeNegocioException("bad.proyectoNoExiste", List.of(String.valueOf(proyecto.getId())));
        }

        // Si cambio el nombre, este no debe existir en el sistema
        if (!proyectoEntity.get().getNombre().equals(proyecto.getNombre())){
            if (proyectoRepository.existsByNombre(proyecto.getNombre())){
                throw new ReglaDeNegocioException("bad.proyectoYaExiste", List.of(proyecto.getNombre()));
            }
        }

        // La fecha Inicio debe ser antes de la fecha Fin
        if (proyecto.getFechaInicio().isAfter(proyecto.getFechaFin())){
            throw new ReglaDeNegocioException("bad.fechaFinAntesFechaInicio");
        }
    }

    public ProyectoEntity validarGuardarProyecto(GuardarProyectoDTO proyecto){
        Optional<ProyectoEntity> proyectoEntity = proyectoRepository.findById(proyecto.getInformacionGeneral().getId());

        // El proyecto debe Existir
        if (proyectoEntity.isEmpty()){
            throw new ReglaDeNegocioException("bad.proyectoNoExiste", List.of(String.valueOf(proyecto.getInformacionGeneral().getId())));
        }

        // Si cambio el nombre, este no debe existir en el sistema
        if (!proyectoEntity.get().getNombre().equals(proyecto.getInformacionGeneral().getNombre())){
            if (proyectoRepository.existsByNombre(proyecto.getInformacionGeneral().getNombre())){
                throw new ReglaDeNegocioException("bad.proyectoYaExiste", List.of(proyecto.getInformacionGeneral().getNombre()));
            }
        }

        // La fecha Inicio debe ser antes de la fecha Fin
        if(proyecto.getInformacionGeneral().getFechaInicio() != null && proyecto.getInformacionGeneral().getFechaFin() != null ){
            if (proyecto.getInformacionGeneral().getFechaInicio().isAfter(proyecto.getInformacionGeneral().getFechaFin())){
                throw new ReglaDeNegocioException("bad.fechaFinAntesFechaInicio");
            }
        }

        // Lo modifica únicamente un miembro del Proyecto
//        if(!servicioDeIdentificacionDeUsuario.esFuncionario()){
//            Usuario usuario = servicioDeIdentificacionDeUsuario.obtenerUsuario();
//
//            Optional<IntegranteProyectoEntity> integranteProyecto = proyectoEntity.get().getIntegrantes()
//                    .stream()
//                    .filter(integrante ->
//                            integrante.getUsuario().getId().equals(usuario.getId())
//                    )
//                    .findFirst();
//
//            if (integranteProyecto.isEmpty()){
//                throw new ReglaDeNegocioException("bad.proyectoFormalizarNoTienePermisos", List.of(usuario.getNombre(), proyecto.getNombre()));
//            }
//        }

        return proyectoEntity.get();
    }

    public void validarAsociacionDeConvocatoria(long proyectoId, long convocatoriaId){

        if (!proyectoRepository.existsById(proyectoId)){
            throw new ReglaDeNegocioException("bad.proyectoNoExiste", List.of(String.valueOf(proyectoId)));
        }

        if (!convocatoriaRepository.existsById(convocatoriaId)){
            throw new ReglaDeNegocioException("bad.convocatorioNoExiste", List.of(String.valueOf(proyectoId)));
        }
    }

    @Transactional
    public void validarCambioEstadoAprobado(long proyectoId){
        proyectoRepository.updateProyectoEstado(proyectoId, EstadoProyecto.APROBADO);
    }

    @Transactional
    public void validarCambioEstadoFormuladoObser(long proyectoId){
        proyectoRepository.updateProyectoEstado(proyectoId, EstadoProyecto.FORMULADO_OBSERVACIONES);
    }

    @Transactional
    public void validarCambioEstadoRevisionVRI(long proyectoId){
        Optional<ProyectoEntity> proyectoEntity = proyectoRepository.findById(proyectoId);

        if (proyectoEntity.isEmpty()){
            throw new ReglaDeNegocioException("bad.proyectoNoExiste", List.of(String.valueOf(proyectoId)));
        }

        validarProyectoInformacionGeneral(proyectoEntity.get());
        validarProyectoConvocatoria(proyectoEntity.get());
        validarProyectoIntegrantes(proyectoEntity.get());
        validarProyectoCompromiso(proyectoEntity.get());

        proyectoRepository.updateProyectoEstado(proyectoId, EstadoProyecto.REVISION_VRI);
    }

    private void validarProyectoCompromiso(ProyectoEntity proyecto) {
        if (proyecto.getCompromisos().isEmpty()){
            throw new ReglaDeNegocioException("bad.compromisoProyecto");
        }
    }

    private void validarProyectoConvocatoria(ProyectoEntity proyecto) {
        if (proyecto.getConvocatoria() == null){
            throw new ReglaDeNegocioException("bad.convocatoriaFalta", List.of("El proyecto debe estar asociado a una Convocatoria"));
        }
    }

    private void validarProyectoIntegrantes(ProyectoEntity proyecto) {
        boolean tieneDirectorActivo = proyecto.getIntegrantes().stream()
                .anyMatch(integrante ->
                        integrante.getRolProyecto().getNombre().equals(RolProyectoEnum.DIRECTOR)
                        && integrante.getEstado()
                );

        if (!tieneDirectorActivo) {
            throw new ReglaDeNegocioException("bad.integrantesProyecto");
        }
    }

    private void validarProyectoInformacionGeneral(ProyectoEntity proyecto) {
        StringBuilder errores = new StringBuilder();

        if (proyecto.getNombre() == null || proyecto.getNombre().trim().isEmpty()) {
            errores.append("El nombre del proyecto es obligatorio.\n");
        }

        if (proyecto.getEstado() == null) {
            errores.append("El estado del proyecto es obligatorio.\n");
        }

        if (proyecto.getFechaInicio() == null) {
            errores.append("La fecha de inicio del proyecto es obligatoria.\n");
        } else if (proyecto.getFechaInicio().isBefore(LocalDate.now())) {
            errores.append("La fecha de inicio debe ser hoy o en el futuro.\n");
        }

        if (proyecto.getFechaFin() == null) {
            errores.append("La fecha de fin del proyecto es obligatoria.\n");
        } else if (proyecto.getFechaFin().isBefore(proyecto.getFechaInicio())) {
            errores.append("La fecha de fin debe ser posterior a la fecha de inicio.\n");
        }

        if (proyecto.getPlanteamiento() == null || proyecto.getPlanteamiento().trim().isEmpty()) {
            errores.append("El planteamiento del proyecto es obligatorio.\n");
        }

        if (proyecto.getObjetivoGeneral() == null || proyecto.getObjetivoGeneral().trim().isEmpty()) {
            errores.append("El objetivo general del proyecto es obligatorio.\n");
        }

        if (proyecto.getObjetivosEspecificos() == null || proyecto.getObjetivosEspecificos().trim().isEmpty()) {
            errores.append("Los objetivos específicos del proyecto son obligatorios.\n");
        }

        if (proyecto.getJustificacion() == null || proyecto.getJustificacion().trim().isEmpty()) {
            errores.append("La justificación del proyecto es obligatoria.\n");
        }

        if (proyecto.getEnfoqueMetodologico() == null || proyecto.getEnfoqueMetodologico().trim().isEmpty()) {
            errores.append("El enfoque metodológico del proyecto es obligatorio.\n");
        }

        if (proyecto.getAspectosEticosLegales() == null || proyecto.getAspectosEticosLegales().trim().isEmpty()) {
            errores.append("Los aspectos éticos y legales son obligatorios.\n");
        }

        if (proyecto.getConfidencialidad() == null || proyecto.getConfidencialidad().trim().isEmpty()) {
            errores.append("La confidencialidad del proyecto es obligatoria.\n");
        }

        if (proyecto.getEfectosAdversos() == null || proyecto.getEfectosAdversos().trim().isEmpty()) {
            errores.append("Los efectos adversos del proyecto son obligatorios.\n");
        }

        if (proyecto.getImpacResulEsperados() == null || proyecto.getImpacResulEsperados().trim().isEmpty()) {
            errores.append("El impacto de los resultados esperados es obligatorio.\n");
        }

        if (proyecto.getConsideraciones() == null || proyecto.getConsideraciones().trim().isEmpty()) {
            errores.append("Las consideraciones del proyecto son obligatorias.\n");
        }

        if (proyecto.isEliminadoLogico()) {
            errores.append("El proyecto no puede estar eliminado lógicamente.\n");
        }

        // Si se encontraron errores, lanzamos una excepción con todos los errores concatenados
        if (!errores.isEmpty()) {
            throw new ReglaDeNegocioException("bad.informacionGeneralFalta", List.of(errores.toString().trim()));
        }
    }





}
