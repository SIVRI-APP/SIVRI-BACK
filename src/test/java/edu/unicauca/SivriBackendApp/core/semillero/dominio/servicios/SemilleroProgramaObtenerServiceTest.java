package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.SemilleroProgramaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarProgramas;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SemilleroProgramaObtenerServiceTest {
    @InjectMocks
    private SemilleroProgramaObtenerService semilleroProgramaObtenerService;
    @Mock
    private SemilleroProgramaObtenerREPO semilleroProgramaObtenerREPO;
    @Mock
    private ResourceBundle resourceBundle;
    @Before
    public void setUp() {

        MockitoAnnotations.openMocks(this);
        when(resourceBundle.getString(anyString())).thenReturn("Mensaje simulado");
    }
    @Test
    public void testExistePorId_Existe() {
        long id = 1;

        // Configurar el mock para que devuelva true
        when(semilleroProgramaObtenerREPO.existePorId(id)).thenReturn(true);

        // Invocar el método del servicio
        Respuesta<Boolean> respuesta = semilleroProgramaObtenerService.existePorId(id);

        // Verificar que la respuesta no es nula
        assertNotNull(respuesta);

        // Verificar que el código de la respuesta es 200
        assertEquals(200, respuesta.getStatus());

        // Verificar que el dato devuelto es true
        assertTrue(respuesta.getData());
    }
    @Test
    public void testExistePorId_NoExiste() {
        long id = 16;

        // Configurar el mock para que devuelva false
        when(semilleroProgramaObtenerREPO.existePorId(id)).thenReturn(false);

        // Verificar que se lanza la excepción esperada
        assertThrows(ReglaDeNegocioException.class, () -> {
            semilleroProgramaObtenerService.existePorId(id);
        });
    }
    @Test
    public void testObtenerPorId_RegistroEncontrado() {
        long id = 1;
        SemilleroPrograma semilleroPrograma = new SemilleroPrograma(); // Crear un objeto de prueba

        // Configurar el mock para devolver un Optional con el objeto
        when(semilleroProgramaObtenerREPO.obtenerPorId(id)).thenReturn(Optional.of(semilleroPrograma));

        // Invocar el método del servicio
        Respuesta<SemilleroPrograma> respuesta = semilleroProgramaObtenerService.obtenerPorId(id);

        // Verificar que la respuesta no es nula
        assertNotNull(respuesta);

        // Verificar que el código de la respuesta es 200
        assertEquals(200, respuesta.getStatus());

        // Verificar que el dato devuelto es el esperado
        assertEquals(semilleroPrograma, respuesta.getData());
    }
    @Test
    public void testObtenerPorId_RegistroNoEncontrado() {
        long id = 15;

        // Configurar el mock para devolver un Optional vacío
        when(semilleroProgramaObtenerREPO.obtenerPorId(id)).thenReturn(Optional.empty());

        // Verificar que se lanza la excepción esperada
        assertThrows(ReglaDeNegocioException.class, () -> {
            semilleroProgramaObtenerService.obtenerPorId(id);
        });
    }
    @Test
    public void testObtenerListadoProgramasPorSemilleroId_SeEncuentranRegistros() {
        int idSemillero = 2;
        int pageNo = 0;
        int pageSize = 10;
        Page<ListarProgramas> paginaSimulada = new PageImpl<>(List.of(new ListarProgramas() {
            @Override
            public Integer getId() {
                return null;
            }

            @Override
            public String getNombre() {
                return null;
            }
        }));

        // Configurar el mock para devolver una página con datos
        when(semilleroProgramaObtenerREPO.obtenerListadoProgramasPorSemilleroId(any(Pageable.class), eq(idSemillero)))
                .thenReturn(paginaSimulada);

        // Invocar el método del servicio
        Respuesta<Page<ListarProgramas>> respuesta = semilleroProgramaObtenerService.obtenerListadoProgramasPorSemilleroId(pageNo, pageSize, idSemillero);

        // Verificar que la respuesta no es nula
        assertNotNull(respuesta);

        // Verificar que el código de la respuesta es 200
        assertEquals(200, respuesta.getStatus());

        // Verificar que el dato devuelto es el esperado
        assertEquals(paginaSimulada, respuesta.getData());
    }
    @Test
    public void testObtenerListadoProgramasPorSemilleroId_NoSeEncuentranRegistros() {
        int idSemillero = 1;
        int pageNo = 0;
        int pageSize = 10;
        Page<ListarProgramas> paginaVacia = Page.empty();

        // Configurar el mock para devolver una página vacía
        when(semilleroProgramaObtenerREPO.obtenerListadoProgramasPorSemilleroId(any(Pageable.class), eq(idSemillero)))
                .thenReturn(paginaVacia);

        // Verificar que se lanza la excepción esperada
        assertThrows(ReglaDeNegocioException.class, () -> {
            semilleroProgramaObtenerService.obtenerListadoProgramasPorSemilleroId(pageNo, pageSize, idSemillero);
        });
    }
}
