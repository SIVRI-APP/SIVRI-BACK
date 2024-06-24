package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.LineaInvestigacionObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarLineasInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.LineaInvestigacionEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.LineaInvestigacionMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.ILineaInvestigacionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<List<ListarLineasInvestigacion>> obtenerLineasInvestigacionPorSemilleroId(Pageable pageable, int idSemillero) {
        return lineaInvestigacionRepository.obtenerLineaxSemilleroId(idSemillero,pageable);
    }

    @Override
    public List<LineaInvestigacion> obtenertotListadoLineasInvestigacion(int idSemillero) {
        return lineaInvestigacionRepository.findBySemilleroId(idSemillero).stream().map(lineaInvestigacionMapper::obtenerModelo).collect(Collectors.toList());
    }

    @Override
    public List<LineaInvestigacion> obtenerListadoLineasInvestigacion() {
        return lineaInvestigacionRepository.findAll().stream().map(lineaInvestigacionMapper::obtenerModelo).collect(Collectors.toList());
    }

}
