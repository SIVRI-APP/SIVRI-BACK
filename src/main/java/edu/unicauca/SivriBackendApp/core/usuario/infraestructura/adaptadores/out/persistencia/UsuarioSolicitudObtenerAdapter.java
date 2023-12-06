package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificaciónDeUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.ListarUsuarioSolicitudConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UsuarioSolicitudObtenerAdapter implements UsuarioSolicitudObtenerREPO {

    private final UsuarioSolicitudRepository usuarioSolicitudRepository;

    @Override
    public boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento) {
        return usuarioSolicitudRepository.existsByCorreoOrTipoDocumentoAndNumeroDocumento(correo, tipoDocumento, numeroDocumento );
    }

    @Override
    public Page<ListarUsuarioSolicitudConFiltroProyección> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado, Integer grupoId) {
        Page<ListarUsuarioSolicitudConFiltroProyección> respuestaBd;

        String tipoDoc = (tipoDocumento != null) ? tipoDocumento.toString() : null;
        String tipoUsu = (tipoUsuario != null) ? tipoUsuario.toString() : null;
        String estadoUsu = (estado != null) ? estado.toString() : null;

        // Si la acción es ejecutada de un grupo de investigación especifico
        if (grupoId != null){
            respuestaBd = usuarioSolicitudRepository.listarConFiltroPorGrupo(correo, tipoDoc, numeroDocumento, nombres, apellidos, tipoUsu, estadoUsu, grupoId, pageable);
        }else{
            respuestaBd = usuarioSolicitudRepository.listarConFiltro(correo, tipoDoc, numeroDocumento, nombres, apellidos, tipoUsu, estadoUsu, pageable);
        }

        return respuestaBd;
    }

}
