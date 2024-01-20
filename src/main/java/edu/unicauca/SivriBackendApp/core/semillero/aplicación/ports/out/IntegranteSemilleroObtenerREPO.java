package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroIntegrantesSemillero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IntegranteSemilleroObtenerREPO {
    Optional<IntegranteSemillero> obtenerPorId(int id);

    Page<IntegranteSemillero> obtenerListadoIntegrantesSemilleroPaginado(PageRequest pageRequest);

    List<IntegranteSemillero> obtenerIntegranteSemilleroPorIdSemillero(int idSemillero);
    List<Semillero> obtenerSemillerosPorIdMentor(String idMentor);
    Page<List<ListarConFiltroIntegrantesSemillero>> listarIntegrantesSemilleroConFiltro(Pageable pageable, String numeroDocumento, String rolSemillero, EstadoIntegranteSemillero estado/*, String programa*/);
}
