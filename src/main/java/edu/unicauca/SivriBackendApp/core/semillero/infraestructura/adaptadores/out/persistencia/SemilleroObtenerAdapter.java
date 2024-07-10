package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.SemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroSemilleros;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarSemilleroPorIdMentor;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarSemillerosConFiltroxMentor;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.SemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.SemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.ISemilleroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SemilleroObtenerAdapter implements SemilleroObtenerREPO {
    private final ISemilleroRepository semilleroRepository;
    private final SemilleroMapper semilleroMapper;

    public SemilleroObtenerAdapter(ISemilleroRepository semilleroRepository, SemilleroMapper semilleroMapper) {
        this.semilleroRepository = semilleroRepository;
        this.semilleroMapper = semilleroMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return semilleroRepository.existsById(id);
    }

    @Override
    public Boolean existePorNombre(String nombre) {
        return semilleroRepository.existsByNombre(nombre);
    }

    @Override
    public Optional<Semillero> obtenerSemilleroPorId(int id) {
        Optional<SemilleroEntity> respuestaJpa=semilleroRepository.findById(id);
        System.out.println("respuestaJpa:"+ respuestaJpa);
        if (respuestaJpa.isPresent()){
            System.out.println("coore: "+respuestaJpa.get());
            Semillero semilleromap=semilleroMapper.obtenerModelo(respuestaJpa.get());
            System.out.println("correo: "+semilleromap.getCorreo());
            Optional<Semillero> resp= Optional.of(semilleromap);
            //System.out.println("DATOS DESPUES DEL MAPEO: "+resp);
            return resp;
        }
        return Optional.empty();
    }

    @Override
    public List<Semillero> obtenerSemillerosPorIdGrupo(int idGrupo) {
        return semilleroRepository.findByGrupoId(idGrupo).stream().map(semilleroMapper::obtenerModelo).collect(Collectors.toList());
    }

    @Override
    public List<Semillero> obtenerSemillerosPorIdDirectorGrupo(long idDirector) {
        List<Semillero> semilleros=semilleroRepository.listarxIdDirectorGrupo(idDirector).stream().map(semilleroEntity ->{
            Semillero semillero=semilleroMapper.obtenerModelo(semilleroEntity);
            return semillero;
        }).collect(Collectors.toList());
        return semilleros;
    }

    /* @Override
     public List<Semillero> obtenerSemilleroPorNombre(String nombre) {
         return this.semilleroRepository.findByNombreLikeIgnoreCase(nombre).stream().map(semilleroEntity -> {
             Semillero semillero=semilleroMapper.obtenerModelo(semilleroEntity);
             return semillero;
         }).collect(Collectors.toList());

     }*/
    @Override
    public List<Semillero> obtenerSemilleros() {
        List<Semillero> semilleros=semilleroRepository.findAll().stream().map(semilleroEntity -> {
            Semillero semillero=semilleroMapper.obtenerModelo(semilleroEntity);
            //System.out.println("DATOS SEMILLEROS: "+semillero);
            return semillero;
        }).collect(Collectors.toList());
        return semilleros;
        /*return this.semilleroRepository.findAll().stream().map(semilleroEntity -> {
            Semillero semillero=semilleroMapper.obtenerModelo(semilleroEntity);
            //System.out.println("DATOS SEMILLEROS: "+semillero);
            return semillero;
                }).collect(Collectors.toList());*/
    }

    @Override
    public Page<Semillero> obtenerListadoSemilleroPaginado(PageRequest pageRequest) {
        return semilleroRepository.findAll(pageRequest).map(semilleroMapper::obtenerModelo);
    }

    @Override
    public Page<List<ListarConFiltroSemilleros>> listarSemillerosConfiltro(Pageable pageable, String nombre, String correo, SemilleroEstado estado) {
        System.out.println("ingresa datos al adpter "+nombre+correo+estado);
        String estad= (estado != null) ? estado.toString() : null;
        return semilleroRepository.listarSemillerosConFiltro(nombre,correo, estad, pageable);
    }

    @Override
    public Page<List<ListarSemillerosConFiltroxMentor>> listarSemilleroConFiltroxMentor(Pageable pageable, Integer semilleroId, Long usuarioId, String nombre, SemilleroEstado estado) {
        String estad= (estado != null) ? estado.toString() : null;
        return semilleroRepository.listarSemillerosConFiltroxMentor(semilleroId,usuarioId,nombre,estad,pageable);
    }

    @Override
    public Page<List<ListarSemilleroPorIdMentor>> obtenerSemillerosConFiltroxIdDirector(Pageable pageable, Integer semilleroId, Long usuarioId, String nombre, SemilleroEstado estado) {
        String estad= (estado != null) ? estado.toString() : null;
        return semilleroRepository.listarxFiltroSemilleroPorIdDirector(usuarioId,semilleroId,nombre,estad,pageable);
    }


    @Override
    public Page<List<ListarSemilleroPorIdMentor>> obtenerSemillerosPorIdMentor(Pageable pageable, int idMentor) {
        return semilleroRepository.listarSemilleroPorIdMentor(idMentor,pageable);
    }

    @Override
    public Page<List<ListarSemilleroPorIdMentor>> obtenerSemillerosPorIdDirector(Pageable pageable, Long idDirector) {
        return semilleroRepository.listarSemilleroPorIdDirector(idDirector,pageable);
    }

}
