package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.proyecciones.ListarConFiltro;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.proyecciones.InformacionDetalladaUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoUsuario;
import org.springframework.data.domain.Page;

import java.util.List;


public interface UsuarioObtenerCU {

    Respuesta<InformacionDetalladaUsuario> validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento);
    Respuesta<Boolean> existsByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento);
    Respuesta<Boolean> existsByCorreo(String correo);
    Respuesta<Boolean> existsById(Long id);
    Respuesta<Page<List<ListarConFiltro>>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario);
}
