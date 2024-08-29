package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificacionDeUsuario;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.SemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SemilleroObtenerServiceTest {
    @InjectMocks
    private SemilleroObtenerService semilleroObtenerService;
    @Mock
    private SemilleroObtenerREPO semilleroObtenerREPO;
    @Mock
    private ResourceBundle resourceBundle;
    @Before
    public void setUp() {

        MockitoAnnotations.openMocks(this);
        when(resourceBundle.getString(anyString())).thenReturn("Mensaje simulado");
    }
    @Test
    public void testExistePorId_exito() {
        // Preparar el mock
        int semilleroId = 1;
        when(semilleroObtenerREPO.existePorId(semilleroId)).thenReturn(true);
        // Ejecutar el método a probar
        Respuesta<Boolean> respuesta = semilleroObtenerService.existePorId(semilleroId);
        // Verificar el resultado
        assertEquals(200, respuesta.getStatus());
        assertTrue(respuesta.getData());
    }

    @Test
    public void testExistePorId_noExiste() {
        // Preparar el mock
        int semilleroId = 1;
        when(semilleroObtenerREPO.existePorId(semilleroId)).thenReturn(false);

        // Verificar que se lanza la excepción esperada
        assertThrows(ReglaDeNegocioException.class, () -> {
            semilleroObtenerService.existePorId(semilleroId);
        });
    }

    @Test
    public void testObtenerSemilleroPorId_exito() {
        // Preparar el mock
        int semilleroId = 1;
        Semillero semillero = new Semillero(); // Crea un objeto Semillero con los valores que necesites
        when(semilleroObtenerREPO.obtenerSemilleroPorId(semilleroId)).thenReturn(Optional.of(semillero));

        // Ejecutar el método a probar
        Respuesta<Semillero> respuesta = semilleroObtenerService.obtenerSemilleroPorId(semilleroId);

        // Verificar el resultado
        assertEquals(200, respuesta.getStatus());
        assertEquals(semillero, respuesta.getData());
    }

    @Test
    public void testObtenerSemilleroPorId_noExiste() {
        // Preparar el mock
        int semilleroId = 19;
        when(semilleroObtenerREPO.obtenerSemilleroPorId(semilleroId)).thenReturn(Optional.empty());

        // Verificar que se lanza la excepción esperada
        ReglaDeNegocioException exception = assertThrows(ReglaDeNegocioException.class, () -> {
            semilleroObtenerService.obtenerSemilleroPorId(semilleroId);
        });
        // Verificar el mensaje de la excepción (si el mensaje esperado está en el archivo de propiedades)
        assertEquals("el id " + semilleroId + " no existe.", exception.getMessage());
    }
    @Test
    public void testObtenerSemillerosPorIdGrupo_noSeEncuentranRegistros() {
        int idGrupo = 1;

        // Configurar el mock para retornar una lista vacía
        when(semilleroObtenerREPO.obtenerSemillerosPorIdGrupo(idGrupo)).thenReturn(Collections.emptyList());

        // Verificar que se lanza la excepción esperada
        ReglaDeNegocioException exception = assertThrows(ReglaDeNegocioException.class, () -> {
            semilleroObtenerService.obtenerSemillerosPorIdGrupo(idGrupo);
        });

        // Verificar el mensaje de la excepción (si el mensaje esperado está en el archivo de propiedades)
        assertEquals("no hay semilleros registrados.", exception.getMessage());
    }

}
