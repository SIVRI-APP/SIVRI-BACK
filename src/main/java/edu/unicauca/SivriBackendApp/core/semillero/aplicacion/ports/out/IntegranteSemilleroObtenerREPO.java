package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroIntegrantesSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarIntegrantesSemilleroxIdSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarTodosIntegrantesConFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IntegranteSemilleroObtenerREPO {
    Optional<IntegranteSemillero> obtenerPorId(int id);

    Page<IntegranteSemillero> obtenerListadoIntegrantesSemilleroPaginado(PageRequest pageRequest);

    List<IntegranteSemillero> obtenerIntegranteSemilleroPorIdSemillero(int idSemillero);
    Page<List<ListarIntegrantesSemilleroxIdSemillero>> obtenerIntegrantesSemilleroPorIdSemillero(Pageable pageable, int idSemillero, String numeroDocumento, String rolSemillero, EstadoIntegranteSemillero estado);

    List<Semillero> obtenerSemillerosPorIdMentor(String idMentor);
    Page<List<ListarConFiltroIntegrantesSemillero>> listarIntegrantesSemilleroConFiltro(Pageable pageable, String numeroDocumento, String rolSemillero, EstadoIntegranteSemillero estado/*, String programa*/);
    Page<List<ListarTodosIntegrantesConFiltro>> listarTodosIntegrantesSemilleroConFiltro(Pageable pageable, String numeroDocumento, String nombres, Integer semilleroId, String nombreSemillero, String rolSemillero, EstadoIntegranteSemillero estado/*,String programa, String facultad*/);

}