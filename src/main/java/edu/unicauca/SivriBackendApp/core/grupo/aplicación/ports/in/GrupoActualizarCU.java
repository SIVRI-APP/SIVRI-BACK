package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;

public interface GrupoActualizarCU {
    Respuesta<Boolean> actualizarPorApoyo(int idGrupo, Grupo nuevosDatos);

    Respuesta<Boolean> actualizarPorDirector(int idGrupo,Grupo nuevosDatos);

    //Respuesta<Boolean> actualizarGrupoFormuladoPorDirector(Grupo datosGrupo);
    //Respuesta<Boolean> actualizarGrupoActivoPorDirector(Grupo datosGrupo);

}
