package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Departamento;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Programa;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioInfraSimpleMapper {

    public UsuarioEntity fromModelToEntityUsingIdOnly(Long usuarioId) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(usuarioId);

        return usuarioEntity;
    }

    public Usuario toModel(UsuarioEntity entity) {
        Usuario usuario = new Usuario();

        usuario.setId(entity.getId()); // Mapeo del ID
        usuario.setCorreo(entity.getCorreo()); // Correo
        usuario.setTipoDocumento(entity.getTipoDocumento()); // Tipo de documento
        usuario.setNumeroDocumento(entity.getNumeroDocumento()); // Número de documento
        usuario.setSexo(entity.getSexo()); // Sexo
        usuario.setTipoUsuario(entity.getTipoUsuario()); // Tipo de usuario
        usuario.setNombre(entity.getNombre()); // Nombre
        usuario.setApellido(entity.getApellido()); // Apellido
        usuario.setTelefono(entity.getTelefono()); // Teléfono
        usuario.setCvLac(entity.getCvLac()); // Enlace al CV

        // Mapeo de programa y departamento (ID)
        if (entity.getProgramaId() != null) {
            Programa programa = new Programa();
            programa.setId(entity.getProgramaId());
            usuario.setPrograma(programa);
        }
        if (entity.getDepartamentoId() != null) {
            Departamento departamento = new Departamento();
            departamento.setId(entity.getDepartamentoId());
            usuario.setDepartamento(departamento);
        }

        return usuario;
    }

    public UsuarioEntity toEntity(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();

        entity.setCorreo(usuario.getCorreo()); // Correo
        entity.setTipoDocumento(usuario.getTipoDocumento()); // Tipo de documento
        entity.setNumeroDocumento(usuario.getNumeroDocumento()); // Número de documento
        entity.setSexo(usuario.getSexo()); // Sexo
        entity.setTipoUsuario(usuario.getTipoUsuario()); // Tipo de usuario
        entity.setNombre(usuario.getNombre()); // Nombre
        entity.setApellido(usuario.getApellido()); // Apellido
        entity.setTelefono(usuario.getTelefono()); // Teléfono
        entity.setCvLac(usuario.getCvLac()); // Enlace al CV

        // Mapeo de programa y departamento (ID)
        if (usuario.getPrograma() != null) {
            entity.setProgramaId(usuario.getPrograma().getId());
        }
        if (usuario.getDepartamento() != null) {
            entity.setDepartamentoId(usuario.getDepartamento().getId());
        }

        return entity;
    }

}
