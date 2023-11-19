package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.IntegranteSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper.IntegranteSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.IntegranteSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository.IIntegranteSemilleroRepository;
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
    public List<IntegranteSemillero> obtenerIntegrantesSemillero() {

        List<IntegranteSemillero> integranteSemillero= integranteSemilleroRepository.findAll().stream().map(integranteSemilleroMapper::obtenerModelo).collect(Collectors.toList());
      //  System.out.println("INTEGRANTE SEMILLERO "+integranteSemillero);
        return integranteSemillero;
    }

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
