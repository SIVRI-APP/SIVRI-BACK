package edu.unicauca.SivriBackendApp.core.grupo.domain.port.out;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface GrupoObtenerREPO {
    Boolean existePorId(int id);
    Boolean existePorNombre(String nombre);
    Optional<Grupo> obtenerGrupoPorId(int id);
    List<Grupo> obtenerGrupos();
    Page<Grupo> obtenerGruposPaginado(PageRequest pageRequest);

}
