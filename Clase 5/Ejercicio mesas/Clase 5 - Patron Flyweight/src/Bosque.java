import java.util.ArrayList;
import java.util.List;

public class Bosque {
    private List<Arbol> arboles;

    public Bosque() {
        this.arboles = new ArrayList<>();
    }

    public void plantarArbol(String tipo) {
        Arbol arbol = ArbolFactory.obtenerArbol(tipo);
        arboles.add(arbol);
    }

    public void mostrarArboles() {
        for (Arbol arbol : arboles) {
            System.out.println(arbol);
        }
    }
}

