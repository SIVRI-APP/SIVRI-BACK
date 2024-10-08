package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.RolObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.RolObtenerREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.RolProyectoListarProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RolObtenerService implements RolObtenerCU {

    private final RolObtenerREPO rolObtenerREPO;

    private final UsuarioObtenerCU usuarioObtenerCU;

    @Override
    public Respuesta<RolProyecto> obtenerRolPorId(int rolId) {

        Optional<RolProyecto> rol = rolObtenerREPO.obtenerProyectoPorId(rolId);

        if (rol.isEmpty()){
            throw new ReglaDeNegocioException("bad.rolNoExiste", List.of(String.valueOf(rolId)));
        }

        return new RespuestaHandler<>(200, "ok", "", rol.get()).getRespuesta();
    }

    @Override
    public Respuesta<RolProyecto> obtenerRolPorEnum(RolProyectoEnum rolId) {

        Optional<RolProyecto> rol = rolObtenerREPO.obtenerRolPorEnum(rolId);

        if (rol.isEmpty()){
            throw new ReglaDeNegocioException("bad.rolNoExiste", List.of(String.valueOf(rolId)));
        }

        return new RespuestaHandler<>(200, "ok", "", rol.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<RolProyectoListarProyeccion>> retornarRoles(TipoUsuario tipoUsuario, long proyectoId) {
        List<RolProyectoListarProyeccion> roles = rolObtenerREPO.retornarRoles();

        if (roles.isEmpty()){
            throw new ReglaDeNegocioException("bad.noRolesDisponibles");
        }

        if (rolObtenerREPO.tieneDirector(proyectoId)){
            roles.removeIf(rol -> rol.getNombre().toString().equals("DIRECTOR"));
        }

        if (tipoUsuario.equals(TipoUsuario.ADMINISTRATIVO)){
            throw new ReglaDeNegocioException("bad.admini.rol.proyecto");
        }

        if (tipoUsuario.equals(TipoUsuario.DOCENTE)){
            List<String> nombresParaEliminar = List.of("ESTUDIANTE_DOCTORADO", "ESTUDIANTE_ESPECIALIZACION", "ESTUDIANTE_MAESTRIA", "ESTUDIANTE_POSTDOCTORADO", "ESTUDIANTE_PREGRADO", "INVESTIGADOR_EXTERNO", "JOVEN_INVESTIGADOR", "PERSONAL_TECNICO");
            roles.removeIf(rol -> nombresParaEliminar.contains(rol.getNombre()));
        }

        if (tipoUsuario.equals(TipoUsuario.EXTERNO)){
            roles.removeIf(rol -> !rol.getNombre().equals("INVESTIGADOR_EXTERNO"));
        }

        if (tipoUsuario.equals(TipoUsuario.PREGRADO)){
            List<String> nombresParaEliminar = List.of("DIRECTOR", "CO_INVESTIGADOR", "ASESOR", "ESTUDIANTE_DOCTORADO", "ESTUDIANTE_ESPECIALIZACION", "ESTUDIANTE_MAESTRIA", "ESTUDIANTE_POSTDOCTORADO", "INVESTIGADOR_EXTERNO", "PERSONAL_TECNICO");
            roles.removeIf(rol -> nombresParaEliminar.contains(rol.getNombre()));
        }

        if (tipoUsuario.equals(TipoUsuario.POSGRADO)){
            List<String> nombresParaEliminar = List.of("DIRECTOR", "CO_INVESTIGADOR", "ASESOR", "INVESTIGADOR_EXTERNO", "PERSONAL_TECNICO", "ESTUDIANTE_PREGRADO", "JOVEN_INVESTIGADOR");
            roles.removeIf(rol -> nombresParaEliminar.contains(rol.getNombre()));
        }

        if (tipoUsuario.equals(TipoUsuario.EGRESADO)){
            roles.removeIf(rol -> !rol.getNombre().equals("ASESOR"));
        }

        return new RespuestaHandler<>(200, "ok", "", roles).getRespuesta();
    }

    @Override
    public Respuesta<List<RolProyecto>> obtenesRolesParaAsignarRolProyecto(long usuarioId, long proyectoId) {
        Respuesta<Usuario> usuario = usuarioObtenerCU.obtenerUsuario(usuarioId);
        TipoUsuario tipoUsuario = usuario.getData().getTipoUsuario();

        List<RolProyecto> roles = rolObtenerREPO.findAll();
        if (roles.isEmpty()){
            throw new ReglaDeNegocioException("bad.noRolesDisponibles");
        }

        if (rolObtenerREPO.tieneDirector(proyectoId)){
            roles.removeIf(rol -> rol.getNombre().toString().equals("DIRECTOR"));
        }

        if (tipoUsuario.equals(TipoUsuario.ADMINISTRATIVO)){
            throw new ReglaDeNegocioException("bad.admini.rol.proyecto");
        }

        if (tipoUsuario.equals(TipoUsuario.DOCENTE)){
            List<String> nombresParaEliminar = List.of("ESTUDIANTE_DOCTORADO", "ESTUDIANTE_ESPECIALIZACION", "ESTUDIANTE_MAESTRIA", "ESTUDIANTE_POSTDOCTORADO", "ESTUDIANTE_PREGRADO", "INVESTIGADOR_EXTERNO", "JOVEN_INVESTIGADOR", "PERSONAL_TECNICO");
            roles.removeIf(rol -> nombresParaEliminar.contains(rol.getNombre().toString()));
        }

        if (tipoUsuario.equals(TipoUsuario.EXTERNO)){
            roles.removeIf(rol -> !rol.getNombre().toString().equals("INVESTIGADOR_EXTERNO"));
        }

        if (tipoUsuario.equals(TipoUsuario.PREGRADO)){
            List<String> nombresParaEliminar = List.of("DIRECTOR", "CO_INVESTIGADOR", "ASESOR", "ESTUDIANTE_DOCTORADO", "ESTUDIANTE_ESPECIALIZACION", "ESTUDIANTE_MAESTRIA", "ESTUDIANTE_POSTDOCTORADO", "INVESTIGADOR_EXTERNO", "PERSONAL_TECNICO");
            roles.removeIf(rol -> nombresParaEliminar.contains(rol.getNombre().toString()));
        }

        if (tipoUsuario.equals(TipoUsuario.POSGRADO)){
            List<String> nombresParaEliminar = List.of("DIRECTOR", "CO_INVESTIGADOR", "ASESOR", "INVESTIGADOR_EXTERNO", "PERSONAL_TECNICO", "ESTUDIANTE_PREGRADO", "JOVEN_INVESTIGADOR");
            roles.removeIf(rol -> nombresParaEliminar.contains(rol.getNombre().toString()));
        }

        if (tipoUsuario.equals(TipoUsuario.EGRESADO)){
            roles.removeIf(rol -> !rol.getNombre().toString().equals("ASESOR"));
        }

        return new RespuestaHandler<>(200, "ok", "", roles).getRespuesta();
    }
}
