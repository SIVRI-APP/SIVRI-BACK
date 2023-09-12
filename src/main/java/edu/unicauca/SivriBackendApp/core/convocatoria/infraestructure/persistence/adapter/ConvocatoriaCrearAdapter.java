package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out.ConvocatoriaCrearREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper.ConvocatoriaInfraMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaRepository.IConvocatoriaRepository;

import org.springframework.stereotype.Component;

@Component
public class ConvocatoriaCrearAdapter implements ConvocatoriaCrearREPO {

    private final IConvocatoriaRepository convocatoriaRepository;
    private final ConvocatoriaInfraMapper convocatoriaInfraMapper;

    public ConvocatoriaCrearAdapter(IConvocatoriaRepository convocatoriaRepository, ConvocatoriaInfraMapper convocatoriaInfraMapper) {
        this.convocatoriaRepository = convocatoriaRepository;
        this.convocatoriaInfraMapper = convocatoriaInfraMapper;
    }

    @Override
    public Boolean crear(Convocatoria nuevosDatos) {
        convocatoriaRepository.save(convocatoriaInfraMapper.obtenerEntity(nuevosDatos));
        return true;
    }
}
