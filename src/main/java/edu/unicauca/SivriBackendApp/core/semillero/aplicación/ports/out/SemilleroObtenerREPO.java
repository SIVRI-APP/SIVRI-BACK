package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroIntegrantesSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroSemilleros;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarSemilleroPorIdMentor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SemilleroObtenerREPO {
    Boolean existePorId(int id);
    Boolean existePorNombre(String nombre);
    //List<Semillero> obtenerSemilleroPorIdAndNombre(int idSemillero, String nombre);
    //List<Semillero> obtenerSemilleroPorNombre(String nombre);

    Optional<Semillero> obtenerSemilleroPorId(int id);
    //Optional<Semillero> obtenerSemilleroPorNombre(String nombre);
    List<Semillero> obtenerSemillerosPorIdGrupo(int idGrupo);
    Page<List<ListarSemilleroPorIdMentor>> obtenerSemillerosPorIdMentor(Pageable pageable, int idMentor);
    List<Semillero> obtenerSemilleros();
    Page<Semillero> obtenerListadoSemilleroPaginado(PageRequest pageRequest);
    Page<List<ListarConFiltroSemilleros>> listarSemillerosConfiltro(Pageable pageable, String nombre, String correo, SemilleroEstado estado);


}
