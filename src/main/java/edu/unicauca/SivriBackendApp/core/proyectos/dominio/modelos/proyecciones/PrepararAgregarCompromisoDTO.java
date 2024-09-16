package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProductoProyectoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PrepararAgregarCompromisoDTO {

    private List<ProductoProyectoEntity> productos;
    private ProyectoIntegrantesProyeccion integrantesProyecto;

}
