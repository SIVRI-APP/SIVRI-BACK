package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroProgramaObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.SemilleroProgramaEliminarREPO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SemilleroProgramaEliminarServiceTest {
    @InjectMocks
    private SemilleroProgramaEliminarService semilleroProgramaEliminarService;

    @Mock
    private SemilleroProgramaEliminarREPO semilleroProgramaEliminarREPO;

    @Mock
    private SemilleroProgramaObtenerCU semilleroProgramaObtenerCU;
    @Mock
    private ResourceBundle resourceBundle;
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(resourceBundle.getString(anyString())).thenReturn("Mensaje simulado");
    }

    @Test
    public void testEliminacionSemilleroProgramaFisico_Exitoso() {
        // Datos de prueba
        long id = 1;

        // Mock del comportamiento
        when(semilleroProgramaObtenerCU.existePorId(id)).thenReturn(new Respuesta<>());
        when(semilleroProgramaEliminarREPO.eliminadoFisicoSemilleroPrograma(id)).thenReturn(true);

        // Llamada al método
        Respuesta<Boolean> respuesta = semilleroProgramaEliminarService.eliminacionSemilleroProgramaFisico(id);

        // Verificar resultados
        Assertions.assertTrue(respuesta.getData());
        verify(semilleroProgramaEliminarREPO, times(1)).eliminadoFisicoSemilleroPrograma(id);
    }

    @Test
    public void testEliminacionSemilleroProgramaFisico_NoExiste() {
        // Datos de prueba
        long id = 1L;

        // Mock del comportamiento
        when(semilleroProgramaObtenerCU.existePorId(id)).thenReturn(new Respuesta<>());

        // Verificar que lanza la excepción esperada
        assertThrows(ReglaDeNegocioException.class, () -> {
            semilleroProgramaEliminarService.eliminacionSemilleroProgramaFisico(id);
        });
    }

    @Test
    public void testEliminacionSemilleroProgramaFisico_ErrorEnEliminacion() {
        // Datos de prueba
        long id = 1L;

        // Mock del comportamiento
        when(semilleroProgramaObtenerCU.existePorId(id)).thenReturn(new Respuesta<>());
        when(semilleroProgramaEliminarREPO.eliminadoFisicoSemilleroPrograma(id)).thenReturn(false);

        // Verificar que lanza la excepción esperada
        assertThrows(ReglaDeNegocioException.class, () -> {
            semilleroProgramaEliminarService.eliminacionSemilleroProgramaFisico(id);
        });
    }
}
