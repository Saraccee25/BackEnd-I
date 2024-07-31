import java.util.ArrayList;
import java.util.List;

public class BusquedaVuelo {
    public static List<String> buscarVuelos(String fechaSalida, String fechaRegreso, String origen, String destino) {

        List<String> vuelos = new ArrayList<>();
        vuelos.add("Vuelo 1: " + origen + " a " + destino + " - Salida: " + fechaSalida + " - Regreso: " + fechaRegreso);
        vuelos.add("Vuelo 2: " + origen + " a " + destino + " - Salida: " + fechaSalida + " - Regreso: " + fechaRegreso);
        return vuelos;
    }
}
