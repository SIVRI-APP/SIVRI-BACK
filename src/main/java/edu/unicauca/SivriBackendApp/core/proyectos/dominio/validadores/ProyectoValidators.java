package edu.unicauca.SivriBackendApp.core.proyectos.dominio.validadores;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio.ConvocatoriaRepository;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.ProyectoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProyectoValidators {

    private final ProyectoRepository proyectoRepository;
    private final ConvocatoriaRepository convocatoriaRepository;

    public void validarCreacionDeProyecto(Proyecto proyecto){

        if (proyectoRepository.existsByNombre(proyecto.getNombre())){
            throw new ReglaDeNegocioException("bad.proyectoYaExiste", List.of(proyecto.getNombre()));
        }

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
