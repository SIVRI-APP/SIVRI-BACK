package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.ListarUsuarioSolicitudConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioObtenerREPO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UsuarioObtenerService implements UsuarioObtenerCU{

    private final UsuarioObtenerREPO usuarioObtenerREPO;

//    @Override
//    public Respuesta obtenerUsuario(String tipoDocumento, String numeroDocumento) {
//        Optional<InformacionPublicaUsuario> respuestaBd = usuarioObtenerREPO.obtenerUsuario(tipoDocumento, numeroDocumento);
//        if (respuestaBd.isEmpty()){
//            throw new ReglaDeNegocioException("bad.no.se.encontro.usuario", List.of(tipoDocumento, numeroDocumento));
//        }
//
//        return new RespuestaHandler<>(200, "ok.usuario.encontrado", List.of(tipoDocumento, numeroDocumento), "",respuestaBd.get()).getRespuesta();
//    }
//
//    @Override
//    public Respuesta<Boolean> existePorTipoDocumentoNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento) {
//        Boolean respuestaBd = usuarioObtenerREPO.existePorTipoDocumentoNumeroDocumento(tipoDocumento, numeroDocumento);
//        return new RespuestaHandler<>(200, "ok.usuario.encontrado", List.of(tipoDocumento.toString(), numeroDocumento), "",respuestaBd).getRespuesta();
//    }
//
//    @Override
//    public Respuesta<Boolean> existePorCorreo(String correo) {
//        Boolean respuestaBd = usuarioObtenerREPO.existePorCorreo(correo);
//        return new RespuestaHandler<>(200, "ok.usuario.correo.encontrado", List.of(correo), "",respuestaBd).getRespuesta();
//    }
//
//    @Override
//    public Respuesta<Boolean> existePorId(Long id) {
//        Boolean respuestaBd = usuarioObtenerREPO.existePorId(id);
//        return new RespuestaHandler<>(200, "ok.usuario.correo.encontrado", List.of(id), "",respuestaBd).getRespuesta();
//    }

    @Override
    public Respuesta<Page<List<ListarUsuarioSolicitudConFiltroProyección>>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<List<ListarUsuarioSolicitudConFiltroProyección>> respuestaBd = usuarioObtenerREPO.listarConFiltro(pageable, correo, tipoDocumento, numeroDocumento, nombres, apellidos, tipoUsuario);
        return new RespuestaHandler<>(200, "ok", "",respuestaBd).getRespuesta();
    }
}
