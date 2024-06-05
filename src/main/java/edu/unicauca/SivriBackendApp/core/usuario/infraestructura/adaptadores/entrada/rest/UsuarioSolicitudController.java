package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioSolicitudCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioSolicitudObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioSolicitudInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioSolicitudListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.entrada.RegistroUsuarioDTO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.mapper.UsuarioSolicitudRestMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarioSolicitud")
@AllArgsConstructor
public class UsuarioSolicitudController {

    /** Puertos de Entrada */
    private final UsuarioSolicitudCrearCU usuarioSolicitudCrearCU;
    private final UsuarioSolicitudObtenerCU usuarioSolicitudObtenerCU;

    /** Mapper */
    private final UsuarioSolicitudRestMapper usuarioSolicitudRestMapper;

    /**
     * REST API para la creación de la solicitud de un Usuario
     *
     * @param registro {@link RegistroUsuarioDTO}
     * @return {@link Respuesta}
     */
    @PostMapping("crearSolicitudUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'SEMILLERO:MENTOR',  " +
            "'PROYECTO:DIRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')"
    )
    public ResponseEntity<Respuesta<Boolean>> crearSolicitudUsuario(@Valid @RequestBody RegistroUsuarioDTO registro) {
        Respuesta<Boolean> respuesta = usuarioSolicitudCrearCU.crearSolicitudUsuario(usuarioSolicitudRestMapper.registrarUsuario(registro));

        return ResponseEntity.ok().body(respuesta);
    }

    /**
     * REST API para popular el datatable de las solicitudes de Usuario
     * @param correo Filtro de Correo
     * @param tipoDocumento Filtro de Tipo de Documento
     * @param numeroDocumento Filtro de Numero de Documento
     * @param nombre Filtro de Nombre
     * @param apellido Filtro de Apellido
     * @param tipoUsuario Filtro de Tipo de Usuario
     * @param estado Filtro de Estado
     * @param pageNo Numero de Pagina
     * @param pageSize Tamaño de Pagina
     * @return {@link Respuesta}
     */
    @GetMapping("listarTodoConFiltro")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'SEMILLERO:MENTOR',  " +
            "'PROYECTO:DIRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')"
    )
    public ResponseEntity<Respuesta<Page<UsuarioSolicitudListarConFiltroProyeccion>>> listarTodoConFiltro(
            @RequestParam(required = false) String correo,
            @RequestParam(required = false) TipoDocumento tipoDocumento,
            @RequestParam(required = false) String numeroDocumento,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) TipoUsuario tipoUsuario,
            @RequestParam(required = false) EstadoSolicitudUsuario estado,
            @RequestParam @Min(value = 0, message = "El valor de pageNo debe ser positivo") int pageNo,
            @RequestParam @Min(value = 0, message = "El valor de pageSize debe ser positivo") int pageSize
    ) {
        Respuesta<Page<UsuarioSolicitudListarConFiltroProyeccion>> respuesta = usuarioSolicitudObtenerCU.listarConFiltro(
                pageNo,
                pageSize,
                correo,
                tipoDocumento,
                numeroDocumento,
                nombre,
                apellido,
                tipoUsuario,
                estado
        );
        return ResponseEntity.ok().body(respuesta);
    }

    /**
     * Obtiene la información detallada de una solicitud de usuario.
     *
     * @param solicitudUsuarioId el ID de la solicitud de usuario. Debe ser un valor positivo.
     * @return {@link Respuesta}
     */
    @GetMapping("obtenerSolicitudUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'SEMILLERO:MENTOR',  " +
            "'PROYECTO:DIRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')"
    )
    public ResponseEntity<Respuesta<UsuarioSolicitudInformacionDetalladaProyeccion>> obtenerSolicitudUsuario(
            @RequestParam @Min(value = 0, message = "El valor de solicitudUsuarioId debe ser positivo") long solicitudUsuarioId)
    {
        Respuesta<UsuarioSolicitudInformacionDetalladaProyeccion> respuesta = usuarioSolicitudObtenerCU.obtenerSolicitudUsuarioInformacionDetallada(solicitudUsuarioId);
        return ResponseEntity.ok().body(respuesta);
    }

    /**
     * Aprueba una solicitud de usuario.
     *
     * @param solicitudUsuarioId el ID de la solicitud de usuario. Debe ser un valor positivo.
     * @return {@link Respuesta}
     */
    @PostMapping("aprobar")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')"
    )
    public ResponseEntity<Respuesta<Boolean>> aprobarSolicitudUsuario(
            @RequestParam @Min(value = 0, message = "El valor de solicitudUsuarioId debe ser positivo") long solicitudUsuarioId)
    {
        Respuesta<Boolean> respuesta = usuarioSolicitudCrearCU.aprobarSolicitudUsuario(solicitudUsuarioId);
        return ResponseEntity.ok().body(respuesta);
    }

}
