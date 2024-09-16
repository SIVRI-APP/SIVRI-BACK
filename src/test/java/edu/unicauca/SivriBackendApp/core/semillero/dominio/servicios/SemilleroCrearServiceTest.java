package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.IntegranteSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.SemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioObtenerCU;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.ResourceBundle;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SemilleroCrearServiceTest {
    @InjectMocks
    private SemilleroCrearService semilleroCrearService;

    @Mock
    private SemilleroCrearREPO semilleroCrearREPO;

    @Mock
    private SemilleroObtenerCU semilleroObtenerCU;

    @Mock
    private GrupoObtenerCU grupoObtenerCU;

    @Mock
    private IntegranteSemilleroCrearCU integranteSemilleroCrearCU;

    @Mock
    private UsuarioObtenerCU usuarioObtenerCU;
    @Mock
    private ResourceBundle resourceBundle;
    private Semillero semillero;
    private long mentorId;
    @Before
    public void setUp() {

        MockitoAnnotations.openMocks(this);
        when(resourceBundle.getString(anyString())).thenReturn("Mensaje simulado");
        semillero = new Semillero();
        semillero.setId(12);
        semillero.setNombre("Semillero de Investigación prueba");
        semillero.setGrupoId(1);
        mentorId = 1;
    }
    @Test
    @Transactional
    public void testCrearSemilleroExito() {
        // Configurar mocks
        when(semilleroObtenerCU.existePorNombre(semillero.getNombre())).thenReturn(new Respuesta<>());
        when(grupoObtenerCU.existePorId(semillero.getGrupoId())).thenReturn(new Respuesta<>());
        when(semilleroCrearREPO.crear(semillero)).thenReturn(semillero);
        when(integranteSemilleroCrearCU.crear(any(IntegranteSemillero.class))).thenReturn(new Respuesta<>());

        // Ejecutar el método a probar
        Respuesta<Boolean> respuesta = semilleroCrearService.crear(semillero, mentorId);

        // Verificar resultados
        assertNotNull(respuesta);
        assertTrue(respuesta.getData());
        assertEquals(201, respuesta.getStatus());
        assertEquals("Elemento Semillero Creado con un Mentor  Asignado Exitosamente", respuesta.getUserMessage());

        // Verificar interacciones con los mocks
        verify(semilleroObtenerCU).existePorNombre(semillero.getNombre());
        verify(grupoObtenerCU).existePorId(semillero.getGrupoId());
        verify(semilleroCrearREPO).crear(semillero);
        verify(integranteSemilleroCrearCU).crear(any(IntegranteSemillero.class));
    }


}
