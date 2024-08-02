import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.List;

public class ListaPromedio {
    private static final Logger logger = LogManager.getLogger(ListaPromedio.class);

    public static void calcularValores(List<Integer> lista) throws Exception {
        if (lista.isEmpty()) {
            logger.error("La lista es igual a cero");
            throw new Exception("La lista no puede estar vacía");
        }

        if (lista.size() > 5) {
            logger.info("La longitud de la lista es mayor a 5");
        }

        if (lista.size() > 10) {
            logger.info("La longitud de la lista es mayor a 10");
        }

        double promedio = lista.stream().mapToInt(Integer::intValue).average().orElse(0);
        int max = lista.stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE);
        int min = lista.stream().mapToInt(Integer::intValue).min().orElse(Integer.MAX_VALUE);

        logger.info("El promedio es: " + promedio);
        logger.info("El valor máximo es: " + max);
        logger.info("El valor mínimo es: " + min);
    }
}
