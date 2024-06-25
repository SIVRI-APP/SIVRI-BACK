package edu.unicauca.SivriBackendApp.core.proyectos.dominio.validadores;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.IntegranteProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.IntegranteRepository;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class IntegranteValidator {

    private IntegranteRepository integranteRepository;

    public void crearIntegrante(Usuario usuario, Proyecto proyecto, RolProyecto rol) {

        // Si es director debe ser de tipo Docente
        // Solo hay un Director de Proyecto
        if (rol.getId() == 1){
            if (!usuario.getTipoUsuario().equals(TipoUsuario.DOCENTE)){
                throw new ReglaDeNegocioException("bad.TipoDirectorDeProyecto", List.of(proyecto.getNombre()));
            }

            List<IntegranteProyectoEntity> cooperaciones = integranteRepository.findAllByProyectoIdAndRolProyectoId(proyecto.getId(), rol.getId());
            if (!cooperaciones.isEmpty()){
                throw new ReglaDeNegocioException("bad.DirectorYaExiste", List.of(proyecto.getNombre()));
            }
        }

        // Si es Co Investigador debe ser de tipo Docente
        if (rol.getId() == 2){
            if (!usuario.getTipoUsuario().equals(TipoUsuario.DOCENTE)){
                throw new ReglaDeNegocioException("bad.TipoCoInvestigador", List.of(proyecto.getNombre()));
            }
        }

        // Validar que el usuario no tenga el mismo rol en el mismo Proyecto
        List<IntegranteProyectoEntity> integrantes = integranteRepository.findAllByUsuarioIdAndProyectoIdAndRolProyectoId(usuario.getId(), proyecto.getId(), rol.getId());
        if (!integrantes.isEmpty()){
            throw new ReglaDeNegocioException("bad.UsuarioYaTieneElRol", List.of(usuario.getNombre(), rol.getNombre().toString(), proyecto.getNombre()));
        }
    }
}
