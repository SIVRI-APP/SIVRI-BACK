package edu.unicauca.SivriBackendApp.core.proyecto.domain.port.out;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface ProyectoObtenerREPO {
    Boolean existePorId(long id);
    Optional<Proyecto> obtenerPorId(long id);
    List<Proyecto> obtenerListado();
    Page<Proyecto> obtenerListadoPaginado(PageRequest pageRequest);
}
