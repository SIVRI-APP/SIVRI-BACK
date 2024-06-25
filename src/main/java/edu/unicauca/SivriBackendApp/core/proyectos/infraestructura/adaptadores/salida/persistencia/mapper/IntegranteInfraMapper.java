package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.IntegranteProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.IntegranteProyectoEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioInfraSimpleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IntegranteInfraMapper {

    private final ProyectoInfraMapper proyectoInfraMapper;
    private final RolInfraMapper rolInfraMapper;
    private final UsuarioInfraSimpleMapper usuarioInfraSimpleMapper;

    public IntegranteProyectoEntity fromModelToEntity(IntegranteProyecto model){
        IntegranteProyectoEntity entity = new IntegranteProyectoEntity();
        entity.setEstado(model.getEstado());
        entity.setFechaFin(model.getFechaFin());
        entity.setFechaInicio(model.getFechaInicio());
        entity.setProyecto(proyectoInfraMapper.fromModelToEntityUsingIdOnly(model.getProyecto().getId()));
        entity.setUsuario(usuarioInfraSimpleMapper.fromModelToEntityUsingIdOnly(model.getUsuario().getId()));
        entity.setRolProyecto(rolInfraMapper.fromModelToEntityUsingIdOnly(model.getRolProyecto().getId()));

        return entity;
    }
}
