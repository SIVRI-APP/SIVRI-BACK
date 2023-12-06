package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.dto.petición.RegistroUsuarioDTO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.mapper.UsuarioRestMapper;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioObtenerCU;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController<T> {

    private final UsuarioCrearCU usuarioCrearCU;
    private final UsuarioObtenerCU usuarioObtenerCU;
    private  final UsuarioRestMapper usuarioRestMapper;

//    @GetMapping("obtenerUsuario")
//    @PreAuthorize("hasAnyAuthority(" +
//            "'GRUPO:DIRECTOR',  " +
//            "'SEMILLERO:MENTOR',  " +
//            "'PROYECTO:DIRECTOR',    " +
//            "'FUNCIONARIO:VICERRECTOR',  " +
//            "'FUNCIONARIO:SUPER_ADMIN', " +
//            "'FUNCIONARIO:USUARIOS',   " +
//            "'FUNCIONARIO:GRUPOS',  " +
//            "'FUNCIONARIO:SEMILLEROS',  " +
//            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
//            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
//    public ResponseEntity<Respuesta> obtenerUsuario(
//            @RequestParam(name = "tipoDocumento") String tipoDocumento,
//            @RequestParam(name = "numeroDocumento") String numeroDocumento
//    ) {
//
//        Respuesta respuesta = usuarioObtenerCU.obtenerUsuario(tipoDocumento, numeroDocumento);
//
//        return ResponseEntity.ok().body(respuesta);
//    }
//
//    @PostMapping("crearUsuario")
//    @PreAuthorize("hasAnyAuthority(" +
//            "'GRUPO:DIRECTOR',  " +
//            "'FUNCIONARIO:SUPER_ADMIN', " +
//            "'FUNCIONARIO:USUARIOS')")
//    public  ResponseEntity<Respuesta> crearUsuario(@Valid @RequestBody RegistroUsuarioDTO registro){
//        Respuesta respuesta = usuarioCrearCU.crearUsuario(usuarioRestMapper.registrarUsuario(registro));
//        return ResponseEntity.ok().body(respuesta);
//    }
//
//    @GetMapping("listarConFiltro")
//    @PreAuthorize("hasAnyAuthority(" +
//            "'FUNCIONARIO:SUPER_ADMIN', " +
//            "'FUNCIONARIO:USUARIOS')")
//    public  ResponseEntity<Respuesta> listarConFiltro(
//            @RequestParam(required = false) String correo,
//            @RequestParam(required = false) TipoDocumento tipoDocumento,
//            @RequestParam(required = false) String numeroDocumento,
//            @RequestParam(required = false) String nombres,
//            @RequestParam(required = false) String apellidos,
//            @RequestParam(required = false) TipoUsuario tipoUsuario,
//            @RequestParam(required = false) int pageNo,
//            @RequestParam(required = false) int pageSize
//    ){
//        Respuesta respuesta = usuarioObtenerCU.listarConFiltro(pageNo, pageSize, correo, tipoDocumento, numeroDocumento, nombres, apellidos, tipoUsuario);
//        return ResponseEntity.ok().body(respuesta);
//    }

}
