package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Departamento;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Programa;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.DepartamentoEntity;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioSolicitudEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioSolicitudInfraSimpleMapper {

    public UsuarioSolicitud toModel(UsuarioSolicitudEntity save) {
        UsuarioSolicitud nuevoUsuario = new UsuarioSolicitud();

        nuevoUsuario.setId(save.getId());
        nuevoUsuario.setCorreo(save.getCorreo());
        nuevoUsuario.setTipoDocumento(save.getTipoDocumento());
        nuevoUsuario.setNumeroDocumento(save.getNumeroDocumento());

        return nuevoUsuario;
    }

    public UsuarioSolicitud toModelCompleto(UsuarioSolicitudEntity entity) {
        UsuarioSolicitud model = new UsuarioSolicitud();

        // Asignar los campos simples
        model.setId(entity.getId());
        model.setCorreo(entity.getCorreo());
        model.setTipoDocumento(entity.getTipoDocumento());
        model.setNumeroDocumento(entity.getNumeroDocumento());
        model.setSexo(entity.getSexo());
        model.setEstado(entity.getEstado());
        model.setTipoUsuario(entity.getTipoUsuario());
        model.setNombre(entity.getNombre());
        model.setApellido(entity.getApellido());
        model.setTelefono(entity.getTelefono());
        model.setCvLac(entity.getCvLac());
        model.setNota(entity.getNota());
        model.setOrganismoDeInvestigacionId(entity.getOrganismoDeInvestigacionId());
        model.setRolId(entity.getRolId());
        model.setTipoOrganismo(entity.getTipoOrganismo());

        // Asignar las relaciones
        if (entity.getCreadoPor() != null) {
            Usuario creadoPor = new Usuario();
            creadoPor.setId(entity.getCreadoPor().getId());
            model.setCreadoPor(creadoPor);
        }

        if (entity.getPrograma() != null) {
            Programa programa = new Programa();
            programa.setId(entity.getPrograma().getId());
            model.setPrograma(programa);
        }

        if (entity.getDepartamento() != null) {
            Departamento departamento = new Departamento();
            departamento.setId(entity.getDepartamento().getId());
            model.setDepartamento(departamento);
        }

        if (entity.getObservaciones() != null) {
            UsuarioSolicitudObservaciones observaciones = new UsuarioSolicitudObservaciones();
            observaciones.setId(entity.getObservaciones().getId());
            model.setObservaciones(observaciones);
        }

        return model;
    }


    public UsuarioSolicitudEntity toEntity(UsuarioSolicitud usuario) {
        UsuarioSolicitudEntity entity = new UsuarioSolicitudEntity();

        // Asignar los campos simples
        entity.setCorreo(usuario.getCorreo());
        entity.setTipoDocumento(usuario.getTipoDocumento());
        entity.setNumeroDocumento(usuario.getNumeroDocumento());
        entity.setSexo(usuario.getSexo());
        entity.setEstado(usuario.getEstado());
        entity.setTipoUsuario(usuario.getTipoUsuario());
        entity.setNombre(usuario.getNombre());
        entity.setApellido(usuario.getApellido());
        entity.setTelefono(usuario.getTelefono());
        entity.setCvLac(usuario.getCvLac());
        entity.setNota(usuario.getNota());
        entity.setOrganismoDeInvestigacionId(usuario.getOrganismoDeInvestigacionId());
        entity.setRolId(usuario.getRolId());
        entity.setTipoOrganismo(usuario.getTipoOrganismo());

        // Asignar las relaciones
        if (usuario.getCreadoPor() != null) {
            UsuarioEntity creadoPorEntity = new UsuarioEntity();
            creadoPorEntity.setId(usuario.getCreadoPor().getId());
            entity.setCreadoPor(creadoPorEntity);
        }

        if (usuario.getPrograma() != null) {
            ProgramaEntity programaEntity = new ProgramaEntity();
            programaEntity.setId(usuario.getPrograma().getId());
            entity.setPrograma(programaEntity);
        }

        if (usuario.getDepartamento() != null) {
            DepartamentoEntity departamentoEntity = new DepartamentoEntity();
            departamentoEntity.setId(usuario.getDepartamento().getId());
            entity.setDepartamento(departamentoEntity);
        }

        return entity;
    }
}
