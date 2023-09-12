package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.adapter;


import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out.TipoFinanciacionObtenerREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper.TipoFinanciacionInfraMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.TipoFinanciacionEntity;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaRepository.ITipoFinanciacionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TipoFinanciacionAdapter implements TipoFinanciacionObtenerREPO {

    private final ITipoFinanciacionRepository tipoFinanciacionRepository;

    private final TipoFinanciacionInfraMapper tipoFinanciacionInfraMapper;

    public TipoFinanciacionAdapter(ITipoFinanciacionRepository tipoFinanciacionRepository, TipoFinanciacionInfraMapper tipoFinanciacionInfraMapper) {
        this.tipoFinanciacionRepository = tipoFinanciacionRepository;
        this.tipoFinanciacionInfraMapper = tipoFinanciacionInfraMapper;
    }

    @Override
    public Boolean existePorId(long id) {
        return tipoFinanciacionRepository.existsById(id);
    }

    @Override
    public Optional<TipoFinanciacion> obtenerPorId(long id) {
        Optional<TipoFinanciacionEntity> respuestaJpa = tipoFinanciacionRepository.findById(id);

        return respuestaJpa.map(tipoFinanciacionInfraMapper::obtenerModelo);
    }

    @Override
    public List<TipoFinanciacion> obtenerListado() {
        return tipoFinanciacionRepository.findAll().stream().map(tipoFinanciacionInfraMapper::obtenerModelo).collect(Collectors.toList());
    }
}
