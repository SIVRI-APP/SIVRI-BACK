package edu.unicauca.SivriBackendApp.core.grupo.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GrupoObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Boolean> existePorNombre(String nombre);
    Respuesta<Grupo> obtenerGrupoPorId(int id);
    Respuesta<List<Grupo>> obtenerGrupos();
    Respuesta<Page<Grupo>> obtenerGruposPaginado(int pageNo, int pageSize);

}
