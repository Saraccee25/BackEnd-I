import java.util.List;

public class BusquedaTurismo implements IBusquedaTurismo {

    @Override
    public void buscar(String ciudad, String fechaDesde, String fechaHasta) {
        System.out.println("Buscando vuelos y hoteles para la ciudad: " + ciudad + " desde: " + fechaDesde + " hasta: " + fechaHasta);
        // Búsqueda de vuelos
        List<String> vuelos = BusquedaVuelo.buscarVuelos(fechaDesde, fechaHasta, "OrigenX", ciudad);
        System.out.println("Vuelos encontrados:");
        for (String vuelo : vuelos) {
            System.out.println(vuelo);
        }
        // Búsqueda de hoteles
        List<String> hoteles = BusquedaHotel.buscarHoteles(fechaDesde, fechaHasta, ciudad);
        System.out.println("Hoteles encontrados:");
        for (String hotel : hoteles) {
            System.out.println(hotel);
        }
    }
}

