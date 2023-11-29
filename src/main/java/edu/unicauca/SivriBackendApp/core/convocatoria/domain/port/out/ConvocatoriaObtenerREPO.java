package edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.out;

import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface ConvocatoriaObtenerREPO {
    Boolean existePorId(long id);
    Optional<Convocatoria> obtenerPorId(long id);
    List<Convocatoria> obtenerListado();
    Page<Convocatoria> obtenerListadoPaginado(PageRequest pageRequest);
}
