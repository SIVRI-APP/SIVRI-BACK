package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones;


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
    UsuarioSolicitudObservacionesProyeccion getObservaciones();

    interface UsuarioSolicitudObservacionesProyeccion {

        Long getId();
        funcionarioProyeccion getFuncionario();
        LocalDate getfechaObservacion();
        Boolean getResuelta();
        String getobservacion();
        Set<UsuarioSolicitudObservacionesConversacionProyeccion> getConversacion();

        interface funcionarioProyeccion {
            funcionarioUsuario getUsuario();

            interface funcionarioUsuario {
                String getNombre();
                String getApellido();
            }
        }

        interface UsuarioSolicitudObservacionesConversacionProyeccion {
            Long getId();
            String getAutor();
            LocalDateTime getFechaMensaje();
            String getMensaje();
        }

    }

}