package edu.unicauca.SivriBackendApp.core.semillero.domain.port.out;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface SemilleroObtenerREPO {
    Boolean existePorId(int id);
    Boolean existePorNombre(String nombre);
    //Optional<Semillero> obtenerSemilleroPorIdOrNombre(int id, String nombre);
    Optional<Semillero> obtenerSemilleroPorId(int id);
    //Optional<Semillero> obtenerSemilleroPorNombre(String nombre);
    List<Semillero> obtenerSemillerosPorIdGrupo(int idGrupo);
    //List<Semillero> obtenerSemillerosPorIdMentor(String idMentor);
    List<Semillero> obtenerSemilleros();
    Page<Semillero> obtenerListadoSemilleroPaginado(PageRequest pageRequest);
}
