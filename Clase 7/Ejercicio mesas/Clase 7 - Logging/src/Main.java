import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> lista1 = Arrays.asList(1, 2, 3, 4, 5, 6);
            ListaPromedio.calcularValores(lista1);

            List<Integer> lista2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
            ListaPromedio.calcularValores(lista2);

            List<Integer> lista3 = Arrays.asList();
            ListaPromedio.calcularValores(lista3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
