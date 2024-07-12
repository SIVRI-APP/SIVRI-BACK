package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.IntegranteSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarConFiltroIntegrantesSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarIntegrantesSemilleroxIdSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarTodosIntegrantesConFiltro;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.IntegranteSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.IntegranteSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IIntegranteSemilleroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class IntegranteSemilleroObtenerAdapter implements IntegranteSemilleroObtenerREPO {
    private final IIntegranteSemilleroRepository integranteSemilleroRepository;

    //private final IUsuarioRepository usuarioRepository;
    private final IntegranteSemilleroMapper integranteSemilleroMapper;

    public IntegranteSemilleroObtenerAdapter(IIntegranteSemilleroRepository integranteSemilleroRepository, IntegranteSemilleroMapper integranteSemilleroMapper) {
        this.integranteSemilleroRepository = integranteSemilleroRepository;
        this.integranteSemilleroMapper = integranteSemilleroMapper;
    }

    @Override
    public Optional<IntegranteSemillero> obtenerPorId(int id) {
        Optional<IntegranteSemilleroEntity> respuestaJpa=integranteSemilleroRepository.findById(id);
        return respuestaJpa.map(integranteSemilleroMapper::obtenerModelo);
    }

    @Override
    public Page<IntegranteSemillero> obtenerListadoIntegrantesSemilleroPaginado(PageRequest pageRequest) {
        return integranteSemilleroRepository.findAll(pageRequest).map(integranteSemilleroMapper::obtenerModelo);
    }

    @Override
    public List<IntegranteSemillero> obtenerIntegranteSemilleroPorIdSemillero(int idSemillero) {
        return integranteSemilleroRepository.findBySemilleroId(idSemillero).stream().map(integranteSemilleroMapper::obtenerModelo).collect(Collectors.toList());
    }

    @Override
    public Page<List<ListarIntegrantesSemilleroxIdSemillero>> obtenerIntegrantesSemilleroPorIdSemillero(Pageable pageable, int idSemillero, String numeroDocumento, String rolSemillero, EstadoIntegranteSemillero estado) {
        String estad= (estado != null) ? estado.toString() : null;
        return integranteSemilleroRepository.obtenerIntegrantesSemilleroPorIdSemillero(idSemillero,numeroDocumento,rolSemillero,estad,pageable);
    }

    @Override
    public Page<List<ListarConFiltroIntegrantesSemillero>> listarIntegrantesSemilleroConFiltro(Pageable pageable, String numeroDocumento, String rolSemillero, EstadoIntegranteSemillero estado/*, String programa*/) {

        String estad= (estado != null) ? estado.toString() : null;
        return integranteSemilleroRepository.listarIntegranteSemilleroConFiltro(numeroDocumento,rolSemillero,estad,pageable);
    }

    @Override
    public Page<List<ListarTodosIntegrantesConFiltro>> listarTodosIntegrantesSemilleroConFiltro(Pageable pageable, String numeroDocumento, String nombres, Integer semilleroId, String nombreSemillero, String rolSemillero, EstadoIntegranteSemillero estado) {
        System.out.println("adapter parametros num doc "+numeroDocumento+"nombr"+nombres+"semilleroid "+semilleroId+ "nom semil "+nombreSemillero+"rol "+rolSemillero+"estado "+estado);

        String estad= (estado != null) ? estado.toString() : null;
        Page<List<ListarTodosIntegrantesConFiltro>> respuestaAdapter=integranteSemilleroRepository.listarTodosIntegranteSemilleroConFiltro(numeroDocumento,nombres,semilleroId,nombreSemillero,rolSemillero,estad,pageable);
        System.out.println("respuesta adapter "+respuestaAdapter);
        return respuestaAdapter;
    }


    /*@Override
    public List<IntegranteSemillero> obtenerIntegrantesSemillero() {

        List<IntegranteSemillero> integranteSemillero= integranteSemilleroRepository.findAll().stream().map(integranteSemilleroMapper::obtenerModelo).collect(Collectors.toList());
      //  System.out.println("INTEGRANTE SEMILLERO "+integranteSemillero);
        return integranteSemillero;
    }
*/
    @Override
    public List<Semillero> obtenerSemillerosPorIdMentor(String idMentor) {
        System.out.println("entra al adapter ");
        //Optional<UsuarioEntity> objUsuario=usuarioRepository.findById(idMentor);
        //System.out.println("OBJ USUARIO: "+objUsuario);

          //  UsuarioEntity objUsuarioObtenido=objUsuario.get();
            // System.out.println("obj usuario obtenido "+objUsuarioObtenido);
            ///List<IntegranteSemilleroEntity> lista=objUsuarioObtenido.getIntegrantes();
            //System.out.println("LISTA "+lista);
            /*ArrayList<SemilleroEntity> semilleros=new ArrayList<>();
            for (IntegranteSemilleroEntity objIntegranteSemillero:lista ) {
                semilleros.add(objIntegranteSemillero.getSemillero());
            }
            List<Semillero> semillerosMapper=semilleros.stream().map(semilleroEntity -> {
                Semillero semillero= integranteSemilleroMapper.obtenerModeloSemillero(semilleroEntity);
                return semillero;
            }).collect(Collectors.toList());
            // System.out.println("SEMILLERO MAPPER "+semillerosMapper);
            return semillerosMapper;
*/
return null;
    }
}
