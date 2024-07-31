public class Arbol {
    //atributos
    private int alto;
    private int ancho;
    private String color;
    private String tipo;
    //constructor
    public Arbol(int alto, int ancho, String color, String tipo) {
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
        this.tipo = tipo;
    }

    public void mostrarInformacion() {
        System.out.println("Árbol [Tipo: " + tipo + ", Alto: " + alto + ", Ancho: " + ancho + ", Color: " + color + "]");
    }


}
