package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.out.SemilleroProgramaActualizarREPO;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.mapper.SemilleroProgramaMapper;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.repository.ISemilleroProgramaRepository;
import org.springframework.stereotype.Component;

@Component
public class SemilleroProgramaActualizarAdapter implements SemilleroProgramaActualizarREPO {
    private final ISemilleroProgramaRepository semilleroProgramaRepository;
    private final SemilleroProgramaMapper semilleroProgramaMapper;

    public SemilleroProgramaActualizarAdapter(ISemilleroProgramaRepository semilleroProgramaRepository, SemilleroProgramaMapper semilleroProgramaMapper) {
        this.semilleroProgramaRepository = semilleroProgramaRepository;
        this.semilleroProgramaMapper = semilleroProgramaMapper;
    }

    @Override
    public Boolean actualizar(SemilleroPrograma nuevosDatos) {
        semilleroProgramaRepository.save(semilleroProgramaMapper.obtenerEntity(nuevosDatos));
        return true;
    }
}
