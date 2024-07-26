import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDescargaTest {
    @Test
    public void testDescargarConUsuarioFree() {
        Usuario usuarioFree = new Usuario("usuario1", "Mario","Free");
        ProxyServicioDescarga proxyDescarga = new ProxyServicioDescarga();

        // Redirigir la salida estándar para capturar el mensaje de acceso denegado
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        proxyDescarga.descargar("Canción A", usuarioFree);

        // Verificar el mensaje de acceso denegado
        assertTrue(outContent.toString().contains("Acceso denegado. Solo los usuarios premium pueden descargar canciones."));
    }

    @Test
    public void testDescargarConUsuarioPremium() {
        Usuario usuarioPremium = new Usuario("usuario2","Sara", "Premium");
        ProxyServicioDescarga proxyDescarga = new ProxyServicioDescarga();

        // Redirigir la salida estándar para capturar el mensaje de descarga
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        proxyDescarga.descargar("Canción B", usuarioPremium);

        // Verificar el mensaje de descarga
        assertTrue(outContent.toString().contains("Descargando la canción: Canción B para el usuario: usuario2"));
    }
}