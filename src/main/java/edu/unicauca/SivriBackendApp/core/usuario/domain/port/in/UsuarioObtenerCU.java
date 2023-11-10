package edu.unicauca.SivriBackendApp.core.usuario.domain.port.in;


import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.ListarConFiltro;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.InformacionDetalladaUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoUsuario;
import org.springframework.data.domain.Page;

import java.util.List;


public interface UsuarioObtenerCU {

    Respuesta<InformacionDetalladaUsuario> validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento);
    Respuesta<Boolean> existsByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento);
    Respuesta<Boolean> existsByCorreo(String correo);
    Respuesta<Boolean> existsById(Long id);
    Respuesta<Page<List<ListarConFiltro>>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario);
}
