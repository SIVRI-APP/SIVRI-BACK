package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.SemilleroProgramaCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.SemilleroProgramaMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.ISemilleroProgramaRepository;
import org.springframework.stereotype.Component;

@Component
public class SemilleroProgramaCrearAdapter implements SemilleroProgramaCrearREPO {
    private final ISemilleroProgramaRepository semilleroProgramaRepository;
    private final SemilleroProgramaMapper semilleroProgramaMapper;

    public SemilleroProgramaCrearAdapter(ISemilleroProgramaRepository semilleroProgramaRepository, SemilleroProgramaMapper semilleroProgramaMapper) {
        this.semilleroProgramaRepository = semilleroProgramaRepository;
        this.semilleroProgramaMapper = semilleroProgramaMapper;
    }

    @Override
    public Boolean crear(SemilleroPrograma nuevosDatos) {
        semilleroProgramaRepository.save(semilleroProgramaMapper.obtenerEntity(nuevosDatos));
        return true;
    }
}
