package edu.unicauca.SivriBackendApp.core.usuario.dominio.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.proyecciones.ListarConFiltro;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.proyecciones.InformacionDetalladaUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioObtenerREPO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UsuarioObtenerService implements UsuarioObtenerCU{

    private final UsuarioObtenerREPO usuarioObtenerREPO;

    @Override
    public Respuesta validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento) {
        Optional<InformacionDetalladaUsuario> respuestaBd = usuarioObtenerREPO.validarExistenciaUsuarioSistema(tipoDocumento, numeroDocumento);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.usuario", List.of(tipoDocumento, numeroDocumento));
        }

        return new RespuestaHandler<>(200, "ok.usuario.encontrado", List.of(tipoDocumento, numeroDocumento), "",respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> existsByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento) {
        Boolean respuestaBd = usuarioObtenerREPO.existsByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
        return new RespuestaHandler<>(200, "ok.usuario.encontrado", List.of(tipoDocumento.toString(), numeroDocumento), "",respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> existsByCorreo(String correo) {
        Boolean respuestaBd = usuarioObtenerREPO.existsByCorreo(correo);
        return new RespuestaHandler<>(200, "ok.usuario.correo.encontrado", List.of(correo), "",respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> existsById(Long id) {
        Boolean respuestaBd = usuarioObtenerREPO.existsById(id);
        return new RespuestaHandler<>(200, "ok.usuario.correo.encontrado", List.of(id), "",respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Page<List<ListarConFiltro>>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<List<ListarConFiltro>> respuestaBd = usuarioObtenerREPO.listarConFiltro(pageable, correo, tipoDocumento, numeroDocumento, nombres, apellidos, tipoUsuario);
        return new RespuestaHandler<>(200, "ok", "",respuestaBd).getRespuesta();
    }
}
