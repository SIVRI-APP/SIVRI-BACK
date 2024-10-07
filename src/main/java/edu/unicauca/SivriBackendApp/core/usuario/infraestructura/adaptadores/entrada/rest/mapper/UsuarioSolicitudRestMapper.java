package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Departamento;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Programa;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada.RegistroUsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UsuarioSolicitudRestMapper {

    public UsuarioSolicitud crearSolicitudUsuario(RegistroUsuarioDTO request){
        UsuarioSolicitud nuevoUsuario = new UsuarioSolicitud();

        nuevoUsuario.setCorreo(request.getCorreo());
        nuevoUsuario.setTipoDocumento(request.getTipoDocumento());
        nuevoUsuario.setNumeroDocumento(request.getNumeroDocumento());
        nuevoUsuario.setSexo(request.getSexo());
        nuevoUsuario.setTipoUsuario(request.getTipoUsuario());
        nuevoUsuario.setNombre(request.getNombre());
        nuevoUsuario.setApellido(request.getApellido());
        nuevoUsuario.setTelefono(request.getTelefono());

        if (Objects.nonNull(request.getNota())){
            nuevoUsuario.setNota(request.getNota());
        }
        if (Objects.nonNull(request.getCvLac())){
            nuevoUsuario.setCvLac(request.getCvLac());
        }
        if (Objects.nonNull(request.getProgramaId())){
            Programa p = new Programa();
            p.setId(request.getProgramaId());
            nuevoUsuario.setPrograma(p);
        }
        if (Objects.nonNull(request.getDepartamentoId())){
            Departamento d = new Departamento();
            d.setId(request.getDepartamentoId());
            nuevoUsuario.setDepartamento(d);
        }

        nuevoUsuario.setTipoOrganismo(request.getTipoOrganismo());
        nuevoUsuario.setOrganismoDeInvestigacionId(request.getOrganismoDeInvestigacionId());
        nuevoUsuario.setRolId(request.getRolId());

        return nuevoUsuario;
    }
}
