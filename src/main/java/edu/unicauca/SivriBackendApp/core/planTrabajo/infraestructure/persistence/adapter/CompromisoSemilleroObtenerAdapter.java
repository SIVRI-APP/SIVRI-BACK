package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.CompromisoSemillero;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.out.CompromisoSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper.CompromisoSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.CompromisoSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaRepository.ICompromisoSemilleroRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CompromisoSemilleroObtenerAdapter implements CompromisoSemilleroObtenerREPO {
    private final ICompromisoSemilleroRepository compromisoSemilleroRepository;
    private final CompromisoSemilleroMapper compromisoSemilleroMapper;

    public CompromisoSemilleroObtenerAdapter(ICompromisoSemilleroRepository compromisoSemilleroRepository, CompromisoSemilleroMapper compromisoSemilleroMapper) {
        this.compromisoSemilleroRepository = compromisoSemilleroRepository;
        this.compromisoSemilleroMapper = compromisoSemilleroMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return compromisoSemilleroRepository.existsById(id);
    }

    @Override
    public Optional<CompromisoSemillero> obtenerPorId(int id) {
        Optional<CompromisoSemilleroEntity> respuestaBd=compromisoSemilleroRepository.findById(id);
        return respuestaBd.map(compromisoSemilleroMapper::obtenerModelo);
    }

    @Override
    public List<CompromisoSemillero> obtenerListadoCompromisos() {
        return compromisoSemilleroRepository.findAll().stream().map(compromisoSemilleroMapper::obtenerModelo).collect(Collectors.toList());
    }
}
