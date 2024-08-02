package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroSemilleros;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarSemilleroPorIdMentor;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarSemillerosConFiltroxMentor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SemilleroObtenerCU {
    Respuesta<Boolean> existePorId(int id);
    Respuesta<Boolean> existePorNombre(String nombre);
    Respuesta<Semillero> obtenerSemilleroPorId(int id);
    //Respuesta<List<Semillero>> obtenerSemillerosPorIdAndNombre(int idSemillero,String nombre);
    //Respuesta<List<Semillero>> obtenerSemillerosPorIdOrNombre(String dato);
    //Respuesta<Semillero> obtenerSemilleroPorIdONombre(Semillero semillero);

    Respuesta<List<Semillero>> obtenerSemillerosPorIdGrupo(int idGrupo);
    Respuesta<List<Semillero>> obtenerSemillerosPorIdDirectorGrupo(long idDirector);
    Respuesta<Page<List<ListarSemilleroPorIdMentor>>> obtenerSemillerosPorIdMentor(int pageNo, int pageSize, int idMentor);
   // Respuesta<Page<List<ListarSemilleroPorIdMentor>>> obtenerSemillerosPorIdDirector(int pageNo, int pageSize, int idMentor);

    Respuesta<List<Semillero>> obtenerSemilleros();
    Respuesta<Page<Semillero>> obtenerSemillerosPaginado(int pageNo, int pageSize);
    Respuesta<Page<List<ListarConFiltroSemilleros>>> listarSemillerosConfiltro(int pageNo, int pageSize, String nombre, String correo, SemilleroEstado estado);

    Respuesta<Page<List<ListarSemillerosConFiltroxMentor>>> listarSemilleroConFiltroxMentor(int pageNo, int pageSize, Integer semilleroId, String nombre, SemilleroEstado estado);
    Respuesta<Page<List<ListarSemilleroPorIdMentor>>> obtenerSemillerosConFiltroxIdDirector(int pageNo, int pageSize, Integer semilleroId, String nombre, SemilleroEstado estado);

}
