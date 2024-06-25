package edu.unicauca.SivriBackendApp.core.proyectos.dominio.validadores;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificacionDeUsuario;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio.ConvocatoriaRepository;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.IntegranteProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.ProyectoInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.ProyectoRepository;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
    }

    public void validarAsociacionDeConvocatoria(long proyectoId, long convocatoriaId){

        if (!proyectoRepository.existsById(proyectoId)){
            throw new ReglaDeNegocioException("bad.proyectoNoExiste", List.of(String.valueOf(proyectoId)));
        }

        if (!convocatoriaRepository.existsById(convocatoriaId)){
            throw new ReglaDeNegocioException("bad.convocatorioNoExiste", List.of(String.valueOf(proyectoId)));
        }

    }


}
