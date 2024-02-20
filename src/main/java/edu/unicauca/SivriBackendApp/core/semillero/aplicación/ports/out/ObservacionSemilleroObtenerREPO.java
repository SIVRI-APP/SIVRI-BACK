package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarObservacionesPorIdSemillero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ObservacionSemilleroObtenerREPO {

    Boolean existePorId(int id);
    Optional<ObservacionSemillero> obtenerPorId(int id);
    Page<List<ListarObservacionesPorIdSemillero>> listarObservacionesPorIdSemillero(Pageable pageable, int semilleroId);
}
