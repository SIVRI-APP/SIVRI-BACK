package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.CompromisoSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.CompromisoSemillero;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.CompromisoSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper.CompromisoSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository.ICompromisoSemilleroRepository;
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
