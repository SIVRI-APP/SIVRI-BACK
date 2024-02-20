package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroIntegrantesSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroSemilleros;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarSemilleroPorIdMentor;
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
    Respuesta<Page<List<ListarSemilleroPorIdMentor>>> obtenerSemillerosPorIdMentor(int pageNo, int pageSize, int idMentor);
    Respuesta<List<Semillero>> obtenerSemilleros();
    Respuesta<Page<Semillero>> obtenerSemillerosPaginado(int pageNo, int pageSize);
    Respuesta<Page<List<ListarConFiltroSemilleros>>> listarSemillerosConfiltro(int pageNo, int pageSize, String nombre, String correo, SemilleroEstado estado);


}
