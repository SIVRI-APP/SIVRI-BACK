package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.validadores;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificacionDeUsuario;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio.ConvocatoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ConvocatoriaValidator {

    private final ConvocatoriaRepository convocatoriaRepository;
    private final ServicioDeIdentificacionDeUsuario servicioDeIdentificacionDeUsuario;

    public void validarCreacionDeConvocatoria(Convocatoria convocatoria){

        // Convocatoria ya Existe
        if (convocatoriaRepository.existsByNombre(convocatoria.getNombre())){
            throw new ReglaDeNegocioException("bad.convocatoriaYaExiste", List.of(String.valueOf(convocatoria.getNombre())));
        }

        // Fecha de Fin y Fecha de Inicio no pueden ser Iguales
        if (convocatoria.getFechaFin().isEqual(convocatoria.getFechaInicio())){
            throw new ReglaDeNegocioException("bad.fechaFin");
        }

        // Fecha Fin antes de Fecha Inicio
        if (convocatoria.getFechaFin().isBefore(convocatoria.getFechaInicio())){
            throw new ReglaDeNegocioException("bad.fechaInicio");
        }

        // No puedes crear una convocatoria de externos si no tienes el ROL para eso
        List<String> roles = servicioDeIdentificacionDeUsuario.obtenerRoles();

        if (convocatoria.getTipoFinanciacion().equals(TipoFinanciacion.PROYECTOS_INTERNOS)){
            if (roles.stream()
                    .noneMatch(
                            rol ->
                            rol.equals("FUNCIONARIO:PROYECTOS_INTERNOS") ||
                            rol.equals("FUNCIONARIO:SUPER_ADMIN") ||
                            rol.equals("FUNCIONARIO:VICERRECTOR")
                    )
            ){
                throw new ReglaDeNegocioException("bad.sinPermisoParaCrearConvocatoria", List.of(String.valueOf(convocatoria.getTipoFinanciacion())));
            }
        }

        if (convocatoria.getTipoFinanciacion().equals(TipoFinanciacion.PROYECTOS_EXTERNOS)){
            if (roles.stream()
                    .noneMatch(
                            rol ->
                            rol.equals("FUNCIONARIO:PROYECTOS_EXTERNOS") ||
                            rol.equals("FUNCIONARIO:SUPER_ADMIN") ||
                            rol.equals("FUNCIONARIO:VICERRECTOR")
                    )
            ){
                throw new ReglaDeNegocioException("bad.sinPermisoParaCrearConvocatoria", List.of(String.valueOf(convocatoria.getTipoFinanciacion())));
            }
        }

    }

}
