package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.ObservacionSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarObservacionesPorIdSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.ObservacionSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.ObservacionSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IObservacionSemilleroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ObservacionSemilleroObtenerAdapter implements ObservacionSemilleroObtenerREPO {

    private final IObservacionSemilleroRepository observacionSemilleroRepository;
    private final ObservacionSemilleroMapper observacionSemilleroMapper;

    public ObservacionSemilleroObtenerAdapter(IObservacionSemilleroRepository observacionSemilleroRepository, ObservacionSemilleroMapper observacionSemilleroMapper) {
        this.observacionSemilleroRepository = observacionSemilleroRepository;
        this.observacionSemilleroMapper = observacionSemilleroMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return observacionSemilleroRepository.existsById(id);
    }

    @Override
    public Optional<ObservacionSemillero> obtenerPorId(int id) {
        Optional<ObservacionSemilleroEntity> respuestaJpa=observacionSemilleroRepository.findById(id);
        return respuestaJpa.map(observacionSemilleroMapper::obtenerModelo);
    }

    @Override
    public Page<List<ListarObservacionesPorIdSemillero>> listarObservacionesPorIdSemillero(Pageable pageable, int semilleroId) {
        return observacionSemilleroRepository.listarObservacionesPorIdSemillero(semilleroId,pageable);
    }
}
