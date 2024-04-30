package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.email.dto.MetaData;
import edu.unicauca.SivriBackendApp.common.email.dto.SendRequest;
import edu.unicauca.SivriBackendApp.common.email.service.SendMessageService;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.RegistroCredencialPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeCredencial;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores.UsuarioValidador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * El servicio UsuarioCrearService implementa la lógica de creación de usuarios y realiza
 * validaciones necesarias antes de persistir los datos en el repositorio de persistencia.
 */
@Service
@RequiredArgsConstructor
public class UsuarioCrearService implements UsuarioCrearCU {

    private final UsuarioCrearREPO usuarioCrearREPO;
    private final UsuarioValidador usuarioValidador;
    private final ServicioDeCredencial servicioDeCredencial;
    private final SendMessageService sendMessageService;

    /**
     * Crea un nuevo usuario en el sistema, realizando validaciones y acciones adicionales según
     * el tipo de usuario. También envía un correo de bienvenida al nuevo usuario.
     *
     * @param usuario Objeto Usuario que contiene la información del nuevo usuario.
     * @return Respuesta que indica el resultado de la creación del usuario.
     */
    @Override
    public Respuesta<Boolean> crearUsuario(Usuario usuario) {
        // Validaciones
        usuarioValidador.validaciónCreaciónUsuario(usuario);

        // Se crea el Usuario
        Usuario nuevoUsuario = usuarioCrearREPO.crearUsuario(usuario);

        // Si es Docente o Administrativo se crean credenciales
        if (usuario.getTipoUsuario().equals(TipoUsuario.DOCENTE) || usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRATIVO)) {
            servicioDeCredencial.registrarCredencial(RegistroCredencialPetición
                    .builder()
                    .usuarioId(nuevoUsuario.getId())
                    .email(nuevoUsuario.getCorreo())
                    .password(nuevoUsuario.getNumeroDocumento())
                    .build());
        }

        // Enviar Correo de Bienvenida
        enviarCorreo(nuevoUsuario);

        return new RespuestaHandler<>(200, "ok", "", true).getRespuesta();
    }

    /**
     * Envía un correo de bienvenida al nuevo usuario, incluyendo información personalizada
     * como el nombre, tipo de usuario, grupo de investigación, etc.
     *
     * @param usuario Objeto Usuario que contiene la información del nuevo usuario.
     * @return Respuesta que indica el resultado del envío del correo.
     */
    private Respuesta enviarCorreo(Usuario usuario) {
        List<MetaData> metaData = new ArrayList<>();
        metaData.add(MetaData.builder()
                .key("nombre")
                .value(usuario.getNombre())
                .build());
        metaData.add(MetaData.builder()
                .key("tipoUsuario")
                .value(usuario.getTipoUsuario().toString())
                .build());
        metaData.add(MetaData.builder()
                .key("grupoInvestigacion")
                .value("PENDIENTE YURANI")
                .build());
        metaData.add(MetaData.builder()
                .key("rolGrupo")
                .value("PENDIENTE YURANI")
                .build());

        return sendMessageService.sendMessage(SendRequest.builder()
                .to(usuario.getCorreo())
                .subject("Te damos la bienvenida a SIVRI")
                .template(1)
                .metaData(metaData)
                .build());
    }
}
