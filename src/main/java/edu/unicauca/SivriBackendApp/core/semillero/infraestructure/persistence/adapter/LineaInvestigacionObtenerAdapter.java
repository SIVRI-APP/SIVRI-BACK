package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.LineaInvestigacionObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper.LineaInvestigacionMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.LineaInvestigacionEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository.ILineaInvestigacionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class LineaInvestigacionObtenerAdapter implements LineaInvestigacionObtenerREPO {
    private final ILineaInvestigacionRepository lineaInvestigacionRepository;
    private final LineaInvestigacionMapper lineaInvestigacionMapper;

    public LineaInvestigacionObtenerAdapter(ILineaInvestigacionRepository lineaInvestigacionRepository, LineaInvestigacionMapper lineaInvestigacionMapper) {
        this.lineaInvestigacionRepository = lineaInvestigacionRepository;
        this.lineaInvestigacionMapper = lineaInvestigacionMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return lineaInvestigacionRepository.existsById(id);
    }

    @Override
    public Optional<LineaInvestigacion> obtenerPorId(int id) {
        Optional<LineaInvestigacionEntity> respuestaJpa=lineaInvestigacionRepository.findById(id);
        return respuestaJpa.map(lineaInvestigacionMapper::obtenerModelo);
    }

    @Override
    public List<LineaInvestigacion> obtenerLineasInvestigacionPorSemilleroId(int idSemillero) {
        return lineaInvestigacionRepository.findBySemilleroId(idSemillero).stream().map(lineaInvestigacionMapper::obtenerModelo).collect(Collectors.toList());
    }

    @Override
    public List<LineaInvestigacion> obtenerListadoLineasInvestigacion() {
        return lineaInvestigacionRepository.findAll().stream().map(lineaInvestigacionMapper::obtenerModelo).collect(Collectors.toList());
    }

}
