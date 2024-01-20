package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.RolesSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.RolSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.RolSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.RolSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IRolSemilleroRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class RolSemilleroObtenerAdapter implements RolesSemilleroObtenerREPO {
    private final IRolSemilleroRepository rolSemilleroRepository;
    private final RolSemilleroMapper rolSemilleroMapper;

    public RolSemilleroObtenerAdapter(IRolSemilleroRepository rolSemilleroRepository, RolSemilleroMapper rolSemilleroMapper) {
        this.rolSemilleroRepository = rolSemilleroRepository;
        this.rolSemilleroMapper = rolSemilleroMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return rolSemilleroRepository.existsById(id);
    }

    @Override
    public List<RolSemillero> obtenerRolesSemillero() {
        return this.rolSemilleroRepository.findAll().stream().map(RolSemilleroEntity ->{
            RolSemillero rolSemillero=rolSemilleroMapper.obtenerModelo(RolSemilleroEntity);
            return rolSemillero;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<RolSemillero> obtenerRolSemilleroPorId(int id) {
        Optional<RolSemilleroEntity> respuestaJpa=rolSemilleroRepository.findById(id);
        if (respuestaJpa.isPresent()) {
            return Optional.of(rolSemilleroMapper.obtenerModelo(respuestaJpa.get()));
        }
        return Optional.empty();
    }

}
