public class Main {
    public static void main(String[] args) {
        Bosque bosque = new Bosque();

        // Plantar 500,000 árboles rojos (Frutales) y 500,000 árboles verdes (Ornamentales)
        for (int i = 0; i < 500000; i++) {
            bosque.plantarArbol("Frutal");
            bosque.plantarArbol("Ornamental");
        }

        // Mostrar algunos árboles para verificar
        bosque.mostrarArboles();

        // Mostrar memoria utilizada
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024) + " MB");
    }
}
