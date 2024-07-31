import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private static final Map<String, Arbol> arboles = new HashMap<>();

    public static Arbol obtenerArbol(String tipo) {
        Arbol arbol = arboles.get(tipo);

        if (arbol == null) {
            switch (tipo) {
                case "Ornamental":
                    arbol = new Arbol(200, 400, "verde", "Ornamental");
                    break;
                case "Frutal":
                    arbol = new Arbol(500, 300, "rojo", "Frutal");
                    break;
                case "Floral":
                    arbol = new Arbol(100, 200, "celeste", "Floral");
                    break;
                default:
                    System.out.println("Tipo de árbol no soportado.");
            }
            arboles.put(tipo, arbol);
        }

        return arbol;
    }
}
