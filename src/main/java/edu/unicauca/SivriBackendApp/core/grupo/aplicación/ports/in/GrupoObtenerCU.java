package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoEstado;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarGruposConFiltro;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarGruposPorIdDirector;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GrupoObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Boolean> existePorNombre(String nombre);
    Respuesta<Grupo> obtenerGrupoPorId(int id);
    Respuesta<List<Grupo>> obtenerGrupos();

    Respuesta<Page<Grupo>> obtenerGruposPaginado(int pageNo, int pageSize);
    Respuesta<List<ListarGruposPorIdDirector>> obtenerGruposPorIdDirector();
    Respuesta<Page<List<ListarGruposPorIdDirector>>> obtenerGruposPorIdDirectorPaginado(int pageNo, int pageSize, int idDirector);
    Respuesta<Page<List<ListarGruposConFiltro>>> obtenerGruposConFiltro(int pageNo, int pageSize, String nombre, GrupoEstado estado, String facultad, String director);


}
