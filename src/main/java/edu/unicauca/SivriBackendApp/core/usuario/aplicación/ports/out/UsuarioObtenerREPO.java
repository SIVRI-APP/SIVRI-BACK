package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.ListarUsuarioSolicitudConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioObtenerREPO {

//    Optional<InformacionPublicaUsuario> obtenerUsuario(String tipoDocumento, String numeroDocumento);
//
//    Boolean existePorTipoDocumentoNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento);
//
//    Boolean existePorCorreo(String correo);
//
//    Boolean existePorId(Long id);

    boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento);

    Page<List<ListarUsuarioSolicitudConFiltroProyección>> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario);

}
