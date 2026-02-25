package com.tt1.test;
import Mock_para_test.MockMailer;
import com.practica.mock.MockRepositorio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test_Servicio {

    private Servicio servicio;
    private Repositorio repositorioReal;
    private MockMailer mockMailer;

    @BeforeAll
    public void testSetUp() {
        // Usamos Repositorio real + MockMailer para tests del Servicio
        // El Servicio necesita hacer cast a Repositorio, así que usamos uno real
        com.practica.service.DBStub db = new com.practica.service.DBStub();
        repositorioReal = new Repositorio(db);
        mockMailer = new MockMailer();
        servicio = new Servicio(repositorioReal, mockMailer);
    }

    @After
    public void tearDown() {
        servicio = null;
        mockMailer = null;
    }

    // ===================== Tests de crearTarea =====================

    @Test
    public void testCrearTareaValida() {
        // Act
        boolean resultado = servicio.crearTarea("Leer libro", LocalDate.of(2026, 3, 1));

        // Assert
        assertTrue("Crear tarea con datos válidos debe devolver true", resultado);
    }

    @Test
    public void testCrearTareaConNombreVacioFalla() {
        // Act
        boolean resultado = servicio.crearTarea("", LocalDate.now());

        // Assert
        assertFalse("Crear tarea con nombre vacío debe devolver false", resultado);
    }

    @Test
    public void testCrearTareaConNombreNuloFalla() {
        // Act
        boolean resultado = servicio.crearTarea(null, LocalDate.now());

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void testCrearTareaConFechaLimiteNulaFalla() {
        // Act
        boolean resultado = servicio.crearTarea("Tarea sin fecha", null);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void testCrearTareaConEspaciosSoloEnNombreFalla() {
        // Act
        boolean resultado = servicio.crearTarea("   ", LocalDate.now());

        // Assert
        assertFalse(resultado);
    }

    // ===================== Tests de agregarEmail =====================

    @Test
    public void testAgregarEmailValido() {
        // Act
        boolean resultado = servicio.agregarEmail("usuario@dominio.com");

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void testAgregarEmailInvalidoSinArroba() {
        // Act
        boolean resultado = servicio.agregarEmail("usuariosindominio");

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void testAgregarEmailInvalidoVacio() {
        // Act
        boolean resultado = servicio.agregarEmail("");

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void testAgregarEmailNuloFalla() {
        // Act
        boolean resultado = servicio.agregarEmail(null);

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void testAgregarEmailInvalidoSinPunto() {
        // Act
        boolean resultado = servicio.agregarEmail("user@dominio");

        // Assert
        assertFalse(resultado);
    }

    // ===================== Tests de marcarComoCompletada =====================

    @Test
    public void testMarcarComoCompletadaExistente() {
        // Arrange
        servicio.crearTarea("Tarea existente", LocalDate.of(2026, 1, 1));

        // Act
        boolean resultado = servicio.marcarComoCompletada("Tarea existente");

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void testMarcarComoCompletadaNoExistente() {
        // Act
        boolean resultado = servicio.marcarComoCompletada("No existo");

        // Assert
        assertFalse(resultado);
    }

    @Test
    public void testMarcarComoCompletadaConNombreVacioFalla() {
        // Act
        boolean resultado = servicio.marcarComoCompletada("");

        // Assert
        assertFalse(resultado);
    }

    // ===================== Tests de listarTareasPendientes =====================

    @Test
    public void testListarTareasPendientesVacio() {
        // Act
        List<ToDo> pendientes = servicio.listarTareasPendientes();

        // Assert
        assertNotNull(pendientes);
        assertEquals(0, pendientes.size());
    }

    @Test
    public void testListarTareasPendientesSoloMuestraPendientes() {
        // Arrange
        servicio.crearTarea("Pendiente", LocalDate.of(2026, 6, 1));
        servicio.crearTarea("Completada", LocalDate.of(2026, 6, 1));
        servicio.marcarComoCompletada("Completada");

        // Act
        List<ToDo> pendientes = servicio.listarTareasPendientes();

        // Assert
        assertEquals(1, pendientes.size());
        assertEquals("Pendiente", pendientes.get(0).getNombre());
    }

    // ===================== Tests de validación de email =====================

    @Test
    public void testEsEmailValidoConEmailCorrecto() {
        assertTrue(servicio.esEmailValido("test@gmail.com"));
        assertTrue(servicio.esEmailValido("usuario.nombre@empresa.org"));
        assertTrue(servicio.esEmailValido("user+tag@dominio.es"));
    }

    @Test
    public void testEsEmailValidoConEmailIncorrecto() {
        assertFalse(servicio.esEmailValido("noesunmail"));
        assertFalse(servicio.esEmailValido("@sinusuario.com"));
        assertFalse(servicio.esEmailValido("usuario@"));
        assertFalse(servicio.esEmailValido(null));
        assertFalse(servicio.esEmailValido(""));
    }

    // ===================== Tests de alertas automáticas =====================

    @Test
    public void testAlertaSeEnviaCuandoHayTareaVencidaYEmails() {
        // Arrange: tarea con fecha ya pasada
        LocalDate ayer = LocalDate.now().minusDays(1);
        servicio.crearTarea("Tarea vencida", ayer);

        // Act: añadir email dispara la comprobación de alertas
        servicio.agregarEmail("alerta@test.com");

        // Assert: debería haberse enviado al menos un correo
        assertTrue("Debe enviarse alerta cuando hay tarea vencida",
            mockMailer.cantidadCorreosEnviados() > 0);
        assertTrue(mockMailer.seEnvioCorreoA("alerta@test.com"));
    }

    @Test
    public void testNoSeEnviaAlertaSiNoHayEmailsEnAgenda() {
        // Arrange: tarea vencida pero sin emails en agenda
        LocalDate ayer = LocalDate.now().minusDays(1);
        servicio.crearTarea("Tarea vencida sin destinatarios", ayer);

        // Assert
        assertEquals(0, mockMailer.cantidadCorreosEnviados());
}
