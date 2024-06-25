package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoEstado;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarGruposConFiltro;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarGruposPorIdDirector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GrupoObtenerREPO {
    Boolean existePorId(int id);
    Boolean existePorNombre(String nombre);
    Optional<Grupo> obtenerGrupoPorId(int id);
    List<Grupo> obtenerGrupos();
    Page<Grupo> obtenerGruposPaginado(PageRequest pageRequest);
    List<ListarGruposPorIdDirector> obtenerGruposPorIdDirector(Long idDirector);
    Page<List<ListarGruposPorIdDirector>> obtenerGruposPorIdDirectorPaginado(Pageable pageable, int idDirector);
    Page<List<ListarGruposConFiltro>> obtenerGruposConFiltro(Pageable pageable, String nombre, GrupoEstado estado, String facultad, String director);
}
