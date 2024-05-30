package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.out.SemilleroProgramaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.proyecciones.ListarProgramas;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.SemilleroProgramaEntity;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.mapper.SemilleroProgramaMapper;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.repository.ISemilleroProgramaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SemilleroProgramaObtenerAdapter implements SemilleroProgramaObtenerREPO {
    private final ISemilleroProgramaRepository semilleroProgramaRepository;
    private final SemilleroProgramaMapper semilleroProgramaMapper;

    public SemilleroProgramaObtenerAdapter(ISemilleroProgramaRepository semilleroProgramaRepository, SemilleroProgramaMapper semilleroProgramaMapper) {
        this.semilleroProgramaRepository = semilleroProgramaRepository;
        this.semilleroProgramaMapper = semilleroProgramaMapper;
    }

    @Override
    public Boolean existePorId(long id) {
        return semilleroProgramaRepository.existsById(id);
    }

    @Override
    public Optional<SemilleroPrograma> obtenerPorId(long id) {
        Optional<SemilleroProgramaEntity> respuestaJpa =semilleroProgramaRepository.findById(id);
        return respuestaJpa.map(semilleroProgramaMapper::obtenerModelo);
    }

    @Override
    public Page<ListarProgramas> obtenerListadoProgramasPorSemilleroId(Pageable pageable, int idSemillero) {
        return semilleroProgramaRepository.obtenerProgramasxSemilleroId(idSemillero,pageable);
        }

}