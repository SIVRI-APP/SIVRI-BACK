package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.GrupoCrearREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.GrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.IntegranteGrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.GrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.IntegranteGrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IGrupoRepository;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IIntegranteGrupoRepository;
import edu.unicauca.SivriBackendApp.core.usuario.domain.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GrupoCrearAdapter implements GrupoCrearREPO {

    private final IGrupoRepository grupoRepository;
    private final IIntegranteGrupoRepository integranteGrupoRepository;
    private final IntegranteGrupoMapper integranteGrupoMapper;
    private final GrupoMapper grupoMapper;

    public GrupoCrearAdapter(IGrupoRepository grupoRepository, IIntegranteGrupoRepository integranteGrupoRepository, IntegranteGrupoMapper integranteGrupoMapper, GrupoMapper grupoMapper) {
        this.grupoRepository = grupoRepository;
        this.integranteGrupoRepository = integranteGrupoRepository;
        this.integranteGrupoMapper = integranteGrupoMapper;
        this.grupoMapper = grupoMapper;
    }

    @Override
    public Boolean crear(Grupo nuevoGrupo) {
       // System.out.println("datos que llegan al adapter del grupo que se va a crear "+nuevoGrupo);
        IntegranteGrupo objIntegranteGrupo=new IntegranteGrupo();
        Usuario usuario=new Usuario(nuevoGrupo.getNumeroDocumento());
        RolGrupo idRolGrupo=new RolGrupo(1);
        Grupo grupoIntegrante=new Grupo();
      //  objIntegranteGrupo.setUsuario(usuario);
        objIntegranteGrupo.setRolGrupo(idRolGrupo);
        //objIntegranteGrupo.setRolGrupoId(idRolGrupo);
        objIntegranteGrupo.setEstado(EstadoIntegranteGrupo.ACTIVO);
        objIntegranteGrupo.setFechaInicio(LocalDate.now());

        GrupoEntity grupo= grupoRepository.save(grupoMapper.obtenerEntity(nuevoGrupo));
        grupoIntegrante.setGrupoId(grupo.getId());
        //objIntegranteGrupo.setGrupoId(grupoIntegrante);
     //TODO guardar al integrante asociado al grupo
       // objIntegranteGrupo.setGrupo(grupoIntegrante);
        //integranteGrupoRepository.save(integranteGrupoMapper.obtenerEntity(objIntegranteGrupo));
        //System.out.println("OBJ INTEGRANTE "+objIntegranteGrupo);
        //System.out.println("id del grupo que se creo "+grupo.getId());

        return true;
    }
}
