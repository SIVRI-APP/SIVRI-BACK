package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out.ConvocatoriaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper.ConvocatoriaInfraMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.ConvocatoriaEntity;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaRepository.IConvocatoriaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ConvocatoriaObtenerAdapter implements ConvocatoriaObtenerREPO {

    private final IConvocatoriaRepository convocatoriaRepository;

    private final ConvocatoriaInfraMapper convocatoriaInfraMapper;

    public ConvocatoriaObtenerAdapter(IConvocatoriaRepository convocatoriaRepository, ConvocatoriaInfraMapper convocatoriaInfraMapper) {
        this.convocatoriaRepository = convocatoriaRepository;
        this.convocatoriaInfraMapper = convocatoriaInfraMapper;
    }

    @Override
    public Boolean existePorId(long id) {
        return convocatoriaRepository.existsById(id);
    }

    @Override
    public Optional<Convocatoria> obtenerPorId(long id) {
        Optional<ConvocatoriaEntity> respuestaJpa = convocatoriaRepository.findById(id);

        return respuestaJpa.map(convocatoriaInfraMapper::obtenerModelo);
    }

    @Override
    public List<Convocatoria> obtenerListado() {
        return convocatoriaRepository.findAll().stream().map(convocatoriaInfraMapper::obtenerModelo).collect(Collectors.toList());
    }

    @Override
    public Page<Convocatoria> obtenerListadoPaginado(PageRequest pageRequest) {
        return convocatoriaRepository.findAll(pageRequest).map(convocatoriaInfraMapper::obtenerModelo);
    }
}
