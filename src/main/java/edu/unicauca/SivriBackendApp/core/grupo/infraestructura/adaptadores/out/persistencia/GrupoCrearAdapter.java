package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoCrearREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.IntegranteGrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.GrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.IntegranteGrupoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IGrupoRepository;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IIntegranteGrupoRepository;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GrupoCrearAdapter implements GrupoCrearREPO {

    private final IGrupoRepository grupoRepository;
    private final IIntegranteGrupoRepository integranteGrupoRepository;
    private final IntegranteGrupoMapper integranteGrupoMapper;
    private final GrupoMapper grupoMapper;
    private final UsuarioObtenerCU usuarioObtenerCU;

    public GrupoCrearAdapter(IGrupoRepository grupoRepository, IIntegranteGrupoRepository integranteGrupoRepository, IntegranteGrupoMapper integranteGrupoMapper, GrupoMapper grupoMapper, UsuarioObtenerCU usuarioObtenerCU) {
        this.grupoRepository = grupoRepository;
        this.integranteGrupoRepository = integranteGrupoRepository;
        this.integranteGrupoMapper = integranteGrupoMapper;
        this.grupoMapper = grupoMapper;
        this.usuarioObtenerCU = usuarioObtenerCU;
    }

    @Override
    public Boolean crear(Grupo nuevoGrupo) {
        //System.out.println("datos que llegan al adapter del grupo que se va a crear "+nuevoGrupo);
        //TODO AGREGRAR LO DE USUARIO
        //InformacionDetalladaUsuario integranteDirector=usuarioObtenerCU.validarExistenciaUsuarioSistema(nuevoGrupo.getTipoDocumento().toString(),nuevoGrupo.getNumeroDocumento()).getData();
        IntegranteGrupo objIntegranteGrupo=new IntegranteGrupo();
        RolGrupo idRolGrupo=new RolGrupo(1);
        Usuario director=new Usuario();
        //director.setId(integranteDirector.getId());
        Grupo grupoIntegrante=new Grupo();
        objIntegranteGrupo.setRolGrupo(idRolGrupo);
        objIntegranteGrupo.setEstado(EstadoIntegranteGrupo.ACTIVO);
        objIntegranteGrupo.setFechaInicio(LocalDate.now());
        objIntegranteGrupo.setUsuario(director);

        GrupoEntity grupo= grupoRepository.save(grupoMapper.obtenerEntity(nuevoGrupo));
        grupoIntegrante.setGrupoId(grupo.getId());
        objIntegranteGrupo.setGrupo(grupoIntegrante);
        IntegranteGrupoEntity integrante=integranteGrupoMapper.obtenerEntity(objIntegranteGrupo);
        //System.out.println("INTEGRANTE A GUARDAR COMO DIRECTOR: "+integrante);
        IntegranteGrupoEntity integranteGuardado= integranteGrupoRepository.save(integrante);
        /*System.out.println("integrante grupo entity"+integranteGuardado);
        System.out.println("OBJ INTEGRANTE "+objIntegranteGrupo);
        System.out.println("id del grupo que se creo "+grupo.getId()); */

        return true;
    }
}