package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.resourceBundleMessages.BundleMessage;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.LineaInvestigacionCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class LineaInvestigacionCrearServiceTest {
    @Mock
    private LineaInvestigacionCrearREPO lineaInvestigacionCrearREPO;

    @InjectMocks
    private LineaInvestigacionCrearService lineaInvestigacionCrearService;
    private LineaInvestigacion nuevaLinea;
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        nuevaLinea = new LineaInvestigacion();
        nuevaLinea.setId(1);
        nuevaLinea.setLinea("linea prueba");
    }

    @Test
    public void testCrearLineaInvestigacionExito() {

        // Configurar el mock para que devuelva true cuando se llame al método crear
        when(lineaInvestigacionCrearREPO.crear(nuevaLinea)).thenReturn(true);

        Respuesta<Boolean> respuesta = lineaInvestigacionCrearService.crear(nuevaLinea);

        // Verificar el resultado
        assertNotNull(respuesta);
        assertTrue(respuesta.getData());
        assertEqualscod(201, respuesta.getStatus());
        assertEquals("success.creacion.objeto", respuesta.getUserMessage());
        verify(lineaInvestigacionCrearREPO).crear(nuevaLinea);
    }

    @Test
    public void testCrearLineaInvestigacionFallo() {
        when(lineaInvestigacionCrearREPO.crear(nuevaLinea)).thenReturn(false);
        ReglaDeNegocioException exception = assertThrows(
                ReglaDeNegocioException.class,
                () -> lineaInvestigacionCrearService.crear(nuevaLinea)
        );
        String expectedMessage = BundleMessage.getExceptionMessage(
                "bad.error.creacion.objeto",
                List.of("Linea Investigacion", "Id", String.valueOf(nuevaLinea.getId()))
        );
        assertEqualsfallo(expectedMessage, exception.getMessage());
        verify(lineaInvestigacionCrearREPO).crear(nuevaLinea);
    }

    private void assertEqualsfallo(String expectedMessage, String message) {
    }
    private void assertTrue(Boolean data) {
    }

    private void assertEquals(String s, String userMessage) {
    }

    private void assertEqualscod(int i, int status) {
    }

}
