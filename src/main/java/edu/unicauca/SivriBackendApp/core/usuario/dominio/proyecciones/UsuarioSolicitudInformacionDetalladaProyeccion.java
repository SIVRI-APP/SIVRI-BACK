package edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones;


import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public interface UsuarioSolicitudInformacionDetalladaProyeccion {

    Long getId();
    String getCorreo();
    TipoDocumento getTipoDocumento();
    String getNumeroDocumento();
    Sexo getSexo();
    TipoUsuario getTipoUsuario();
    String getNombre();
    String getApellido();
    String getTelefono();
    String getCvLac();
    EstadoSolicitudUsuario getEstado();
    String getNota();
    Set<UsuarioSolicitudObservacionesProyección> getObservaciones();

    interface UsuarioSolicitudObservacionesProyección {

        Long getId();
        funcionarioProyeccion getFuncionario();
        LocalDate getFechaObservación();
        Boolean getResuelta();
        String getObservación();
        Set<UsuarioSolicitudObservacionesConversacionProyección> getConversacion();

        interface funcionarioProyeccion {
            funcionarioUsuario getUsuario();

            interface funcionarioUsuario {
                String getNombre();
                String getApellido();
            }
        }

        interface UsuarioSolicitudObservacionesConversacionProyección {
            Long getId();
            String getAutor();
            LocalDateTime getFechaMensaje();
            String getMensaje();
        }

    }

}
