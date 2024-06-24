package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;


import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarProgramas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SemilleroProgramaObtenerREPO {
    Boolean existePorId(long id);
    Optional<SemilleroPrograma> obtenerPorId(long id);
    Page<ListarProgramas> obtenerListadoProgramasPorSemilleroId(Pageable pageable, int idSemillero);

}
