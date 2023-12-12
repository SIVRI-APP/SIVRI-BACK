package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioListarConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UsuarioObtenerREPO {

    Optional<Usuario> obtenerUsuario(long usuarioId);

    Optional<UsuarioEntity> obtenerEntidadUsuarioPorCorreo (String correo);

    boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento);

    Page<List<UsuarioListarConFiltroProyección>> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario);

}
