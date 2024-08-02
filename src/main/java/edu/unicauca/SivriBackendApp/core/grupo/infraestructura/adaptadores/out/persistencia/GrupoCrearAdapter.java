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

import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class GrupoCrearAdapter implements GrupoCrearREPO {

    private final IGrupoRepository grupoRepository;
    private final IIntegranteGrupoRepository integranteGrupoRepository;
    private final IntegranteGrupoMapper integranteGrupoMapper;
    private final GrupoMapper grupoMapper;
    private final UsuarioObtenerCU usuarioObtenerCU;

    @Override
    public Boolean crear(Grupo nuevoGrupo) {
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
        IntegranteGrupoEntity integranteGuardado= integranteGrupoRepository.save(integrante);

        return true;
    }
}
