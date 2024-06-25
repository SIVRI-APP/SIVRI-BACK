package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios;

import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.IntegranteCrearCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.IntegranteCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.IntegranteProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.validadores.IntegranteValidator;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class IntegranteCrearService implements IntegranteCrearCU {

    private final IntegranteCrearREPO integranteCrearREPO;
    private final IntegranteValidator integranteValidator;

    @Override
    public void crear(Usuario usuario, Proyecto proyecto, RolProyecto rol) {
        // Validaciones
        integranteValidator.crearIntegrante(usuario, proyecto, rol);

        IntegranteProyecto integranteProyecto = new IntegranteProyecto();
        integranteProyecto.setRolProyecto(rol);
        integranteProyecto.setProyecto(proyecto);
        integranteProyecto.setEstado(true);
        integranteProyecto.setFechaInicio(LocalDate.now());
        integranteProyecto.setUsuario(usuario);

        integranteCrearREPO.crear(integranteProyecto);
    }
}
