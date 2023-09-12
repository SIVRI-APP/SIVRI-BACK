package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out.ActualizarConvocatoriaREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper.ConvocatoriaInfraMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaRepository.IConvocatoriaRepository;
import org.springframework.stereotype.Component;

@Component
public class ActualizarConvocatoriaAdapter implements ActualizarConvocatoriaREPO {

    private final IConvocatoriaRepository convocatoriaRepository;
    private final ConvocatoriaInfraMapper convocatoriaInfraMapper;

    public ActualizarConvocatoriaAdapter(IConvocatoriaRepository convocatoriaRepository, ConvocatoriaInfraMapper convocatoriaInfraMapper) {
        this.convocatoriaRepository = convocatoriaRepository;
        this.convocatoriaInfraMapper = convocatoriaInfraMapper;
    }

    @Override
    public Boolean actualizar(Convocatoria nuevosDatos) {
        convocatoriaRepository.save(convocatoriaInfraMapper.obtenerEntity(nuevosDatos));
        return true;
    }
}
