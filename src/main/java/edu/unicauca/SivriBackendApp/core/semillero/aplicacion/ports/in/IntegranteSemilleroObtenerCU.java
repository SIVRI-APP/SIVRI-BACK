package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

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

public interface IntegranteSemilleroObtenerCU {
    Respuesta<IntegranteSemillero> obtenerPorId(int id);

    Respuesta<Page<IntegranteSemillero>> obtenerListadoIntegrantesSemilleroPaginado(int pageNo, int pageSize);
    Respuesta<List<IntegranteSemillero>> obtenerIntegranteSemilleroPorIdSemillero(int idSemillero);
    Respuesta<Page<List<ListarIntegrantesSemilleroxIdSemillero>>> obtenerIntegrantesSemilleroPorIdSemillero(int pageNo, int pageSize, int idSemillero, String numeroDocumento, Integer rolSemillero, EstadoIntegranteSemillero estado);
    Respuesta<List<Semillero>> obtenerSemillerosPorIdMentor(String idMentor);
    Respuesta<Page<List<ListarConFiltroIntegrantesSemillero>>> listarIntegrantesSemilleroConFiltro(int pageNo, int pageSize, String numeroDocumento, String rolSemillero, EstadoIntegranteSemillero estado/*,String programa*/);
    //Respuesta<Page<List<>>>
    Respuesta<Page<List<ListarTodosIntegrantesConFiltro>>> listarTodosIntegrantesSemilleroConFiltro(int pageNo, int pageSize, String numeroDocumento,String nombres, Integer semilleroId,  String nombreSemillero, String rolSemillero, EstadoIntegranteSemillero estado/*,String programa, String facultad*/);


}
