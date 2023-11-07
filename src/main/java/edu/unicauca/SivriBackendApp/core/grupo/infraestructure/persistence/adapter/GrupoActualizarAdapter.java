package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.GrupoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.GrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IGrupoRepository;
import org.springframework.stereotype.Component;

@Component
public class GrupoActualizarAdapter implements GrupoActualizarREPO {
    private final IGrupoRepository grupoRepository;
    private final GrupoMapper grupoMapper;

    public GrupoActualizarAdapter(IGrupoRepository grupoRepository, GrupoMapper grupoMapper) {
        this.grupoRepository = grupoRepository;
        this.grupoMapper = grupoMapper;
    }

    @Override
    public Boolean actualizarPorApoyo(Grupo nuevosDatos) {
        grupoRepository.save(grupoMapper.obtenerEntity(nuevosDatos));
        return true;
    }

    @Override
    public Boolean actualizarPorDirector(Grupo nuevosDatos) {
        grupoRepository.save(grupoMapper.obtenerEntity(nuevosDatos));

        return true;
    }

    /*@Override
    public Boolean actualizarGrupoFormuladoPorDirector(Grupo datosGrupo) {
        grupoRepository.save(grupoMapper.obtenerEntity(datosGrupo));
        return true;
    }

    @Override
    public Boolean actualizarGrupoActivoPorDirector(Grupo datosGrupo) {
        grupoRepository.save(grupoMapper.obtenerEntity(datosGrupo));
        return true;
    }*/

}
