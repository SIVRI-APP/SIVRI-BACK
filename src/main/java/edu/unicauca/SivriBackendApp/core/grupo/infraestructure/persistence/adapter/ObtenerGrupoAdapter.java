package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.GrupoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.GrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.GrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IGrupoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class ObtenerGrupoAdapter implements GrupoObtenerREPO {
    private final IGrupoRepository grupoRepository;
    private final GrupoMapper grupoMapper;

    public ObtenerGrupoAdapter(IGrupoRepository grupoRepository, GrupoMapper grupoMapper) {
        this.grupoRepository = grupoRepository;
        this.grupoMapper = grupoMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return grupoRepository.existsById(id);
    }

    @Override
    public Boolean existePorNombre(String nombre) {
        return grupoRepository.existsByNombre(nombre);
    }

    @Override
    public Optional<Grupo> obtenerGrupoPorId(int id) {
        System.out.println("ENTRA A OBTENER GRUPO POR ID DEL ADAPTER ");
        Optional<GrupoEntity> respuestaJpa=grupoRepository.findById(id);
        //System.out.println("obtener grupo antes del mapeo. idgrupo "+respuestaJpa.get().getId()+" demas datos propios de grupo "+respuestaJpa.get());
        if (respuestaJpa.isPresent()) {
            Optional<Grupo> resp=Optional.of(grupoMapper.obtenerModelo(respuestaJpa.get()));
            System.out.println("datos de grupo despues del mapeo "+resp.get());
            return resp;
        }
        return Optional.empty();
    }

    @Override
    public List<Grupo> obtenerGrupos() {
         return this.grupoRepository.findAll().stream().map(grupoEntity -> {
             Grupo grupo=grupoMapper.obtenerModelo(grupoEntity);
             return grupo;
         }).collect(Collectors.toList());

    }

    @Override
    public Page<Grupo> obtenerGruposPaginado(PageRequest pageRequest) {
        return grupoRepository.findAll(pageRequest).map(grupoMapper::obtenerModelo);
    }
}
