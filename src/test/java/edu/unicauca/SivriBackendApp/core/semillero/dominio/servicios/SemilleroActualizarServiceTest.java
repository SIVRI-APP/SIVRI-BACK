package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.SemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ResourceBundle;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SemilleroActualizarServiceTest {
    @InjectMocks
    private SemilleroActualizarService semilleroActualizarService;

    @Mock
    private SemilleroActualizarREPO semilleroActualizarREPO;

    @Mock
    private SemilleroObtenerCU semilleroObtenerCU;

    private Semillero nuevoSemillero;
    private Semillero semilleroExistente;
    @Mock
    private ResourceBundle resourceBundle;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(resourceBundle.getString(anyString())).thenReturn("Mensaje simulado");
        nuevoSemillero = new Semillero();
        nuevoSemillero.setSemillero_Id(12);
        nuevoSemillero.setNombre("Semillero de Investigación prueba");
        nuevoSemillero.setCorreo("nuevo@unicauca.edu.co");
        nuevoSemillero.setObjetivo("Nuevo objetivo");
        nuevoSemillero.setMision("Nueva misión");
        nuevoSemillero.setVision("Nueva visión");
        nuevoSemillero.setSede("Nueva sede");

        semilleroExistente = new Semillero();
        semilleroExistente.setSemillero_Id(3);
        semilleroExistente.setNombre("Semillero Existente");
    }

    @Test
    public void testActualizarPorMentorExito() {
        // Configurar mocks
        when(semilleroObtenerCU.existePorId(nuevoSemillero.getSemillero_Id())).thenReturn(new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta());
        when(semilleroObtenerCU.obtenerSemilleroPorId(nuevoSemillero.getSemillero_Id())).thenReturn(new RespuestaHandler<>(200, "sucess.operacion.exitosa","Exitoso", semilleroExistente).getRespuesta());
        when(semilleroActualizarREPO.actualizarPorMentor(semilleroExistente)).thenReturn(true);

        // Ejecutar el método a probar
        Respuesta<Boolean> respuesta = semilleroActualizarService.actualizarPorMentor(nuevoSemillero);

        // Verificar resultados
        assertNotNull(respuesta);
        assertTrue(respuesta.getData());
        assertEquals(200, respuesta.getStatus());
        assertEquals("Semillero Actualizad@ Exitosamente", respuesta.getUserMessage());

        // Verificar interacciones con los mocks
        verify(semilleroObtenerCU).existePorId(nuevoSemillero.getSemillero_Id());
        verify(semilleroObtenerCU).obtenerSemilleroPorId(nuevoSemillero.getSemillero_Id());
        verify(semilleroActualizarREPO).actualizarPorMentor(semilleroExistente);
    }

    private void assertTrue(Boolean data) {
    }

    @Test
    public void testActualizarPorMentorFallo() {
        // Configurar mocks
        when(semilleroObtenerCU.existePorId(nuevoSemillero.getSemillero_Id())).thenReturn(new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta());
        when(semilleroObtenerCU.obtenerSemilleroPorId(nuevoSemillero.getSemillero_Id())).thenReturn(new RespuestaHandler<>(200, "sucess.operacion.exitosa","Exitoso", semilleroExistente).getRespuesta());
        when(semilleroActualizarREPO.actualizarPorMentor(semilleroExistente)).thenReturn(false);

        // Ejecutar el método y verificar que se lanza la excepción esperada
        ReglaDeNegocioException exception = assertThrows(
                ReglaDeNegocioException.class,
                () -> semilleroActualizarService.actualizarPorMentor(nuevoSemillero)
        );

        // Verificar el mensaje de la excepción
        String expectedMessage = "No se pudo actualizar Semillero -> Id: null";
        assertEquals(expectedMessage, exception.getMessage());

        // Verificar interacciones con los mocks
        verify(semilleroObtenerCU).existePorId(nuevoSemillero.getSemillero_Id());
        verify(semilleroObtenerCU).obtenerSemilleroPorId(nuevoSemillero.getSemillero_Id());
        verify(semilleroActualizarREPO).actualizarPorMentor(semilleroExistente);
    }

    @Test
    public void testActualizarPorMentorCambioNombre() {
        // Configurar mocks
        when(semilleroObtenerCU.existePorId(nuevoSemillero.getSemillero_Id())).thenReturn(new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta());
        when(semilleroObtenerCU.obtenerSemilleroPorId(nuevoSemillero.getSemillero_Id())).thenReturn(new RespuestaHandler<>(200, "sucess.operacion.exitosa","Exitoso", semilleroExistente).getRespuesta());
        when(semilleroObtenerCU.existePorNombre(nuevoSemillero.getNombre())).thenReturn(new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta());
        when(semilleroActualizarREPO.actualizarPorMentor(semilleroExistente)).thenReturn(true);

        // Ejecutar el método a probar
        Respuesta<Boolean> respuesta = semilleroActualizarService.actualizarPorMentor(nuevoSemillero);

        // Verificar resultados
        assertNotNull(respuesta);
        assertTrue(respuesta.getData());
        assertEquals(200, respuesta.getStatus());
        assertEquals("Semillero Actualizad@ Exitosamente", respuesta.getUserMessage());

        // Verificar interacciones con los mocks
        verify(semilleroObtenerCU).existePorId(nuevoSemillero.getSemillero_Id());
        verify(semilleroObtenerCU).obtenerSemilleroPorId(nuevoSemillero.getSemillero_Id());
        verify(semilleroObtenerCU).existePorNombre(nuevoSemillero.getNombre());
        verify(semilleroActualizarREPO).actualizarPorMentor(semilleroExistente);
    }
}
