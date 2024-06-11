package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.salida.ConvocatoriaCrearREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.mapper.ConvocatoriaInfraMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio.ConvocatoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConvocatoriaCrearAdapter implements ConvocatoriaCrearREPO {

    private final ConvocatoriaRepository convocatoriaRepository;
    private final ConvocatoriaInfraMapper convocatoriaInfraMapper;

    @Override
    public Convocatoria crearConvocatoria(Convocatoria convocatoria) {
        return convocatoriaInfraMapper.toDto(convocatoriaRepository.save(convocatoriaInfraMapper.toEntity(convocatoria)));
    }
}
