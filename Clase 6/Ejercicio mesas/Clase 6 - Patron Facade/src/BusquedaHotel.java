import java.util.ArrayList;
import java.util.List;

public class BusquedaHotel {
    public static List<String> buscarHoteles(String fechaEntrada, String fechaSalida, String ciudad) {

        List<String> hoteles = new ArrayList<>();
        hoteles.add("Hotel 1 en " + ciudad + " - Entrada: " + fechaEntrada + " - Salida: " + fechaSalida);
        hoteles.add("Hotel 2 en " + ciudad + " - Entrada: " + fechaEntrada + " - Salida: " + fechaSalida);
        return hoteles;
    }
}
