package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.proyecciones.ListarConFiltro;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.proyecciones.InformacionDetalladaUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UsuarioObtenerREPO {

    Optional<InformacionDetalladaUsuario> validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento);

    Boolean existsByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento);

    Boolean existsByCorreo(String correo);

    Boolean existsById(Long id);

    Page<List<ListarConFiltro>> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario);

}
