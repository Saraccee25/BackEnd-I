import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompruebaCalidadTest {
    @Test
    public void testArticuloValido() {
        Articulo articulo = new Articulo("Producto A", 1500, 1250, "sano");
        CompruebaCalidad analista = new CompruebaCalidad();
        analista.verificarCalidad(articulo);
    }

    @Test
    public void testArticuloInvalidoLote() {
        Articulo articulo = new Articulo("Producto B", 999, 1250, "sano");
        CompruebaCalidad analista = new CompruebaCalidad();
        analista.verificarCalidad(articulo);
    }

    @Test
    public void testArticuloInvalidoPeso() {
        Articulo articulo = new Articulo("Producto C", 1500, 1199, "sano");
        CompruebaCalidad analista = new CompruebaCalidad();
        analista.verificarCalidad(articulo);
    }

    @Test
    public void testArticuloInvalidoEnvase() {
        Articulo articulo = new Articulo("Producto D", 1500, 1250, "dañado");
        CompruebaCalidad analista = new CompruebaCalidad();
        analista.verificarCalidad(articulo);
    }
}