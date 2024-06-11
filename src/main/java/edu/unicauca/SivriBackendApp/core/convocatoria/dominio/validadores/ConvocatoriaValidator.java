package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.validadores;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio.ConvocatoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ConvocatoriaValidator {

    private final ConvocatoriaRepository convocatoriaRepository;

    public void validarCreacionDeConvocatoria(Convocatoria convocatoria){

        // Convocatoria ya Existe
        if (convocatoriaRepository.existsByNombre(convocatoria.getNombre())){
            throw new ReglaDeNegocioException("bad.convocatoriaYaExiste", List.of(String.valueOf(convocatoria.getNombre())));
        }
    }

}
