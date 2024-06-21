package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.GrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IGrupoRepository;
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
