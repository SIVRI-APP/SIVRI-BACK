package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoEstado;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarGruposConFiltro;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarGruposPorIdDirector;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.GrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IGrupoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Optional<GrupoEntity> respuestaJpa=grupoRepository.findById(id);
       if (respuestaJpa.isPresent()) {
            Optional<Grupo> resp=Optional.of(grupoMapper.obtenerModelo(respuestaJpa.get()));
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

    @Override
    public List<ListarGruposPorIdDirector> obtenerGruposPorIdDirector(Long idDirector) {
        List<ListarGruposPorIdDirector> grupos=grupoRepository.listarGruposPorIdDirector(idDirector);
        return grupos;
    }

    @Override
    public Page<List<ListarGruposPorIdDirector>> obtenerGruposPorIdDirectorPaginado(Pageable pageable, int idDirector) {
        return grupoRepository.listarGruposPorIdDirectorPaginado(idDirector,pageable);
    }

    @Override
    public Page<List<ListarGruposConFiltro>> obtenerGruposConFiltro(Pageable pageable, String nombre, GrupoEstado estado, String facultad, String director) {
        String estad= (estado != null) ? estado.toString() : null;
        return grupoRepository.obtenerGruposConFiltro(nombre,estad,facultad,director,pageable);
    }
}
