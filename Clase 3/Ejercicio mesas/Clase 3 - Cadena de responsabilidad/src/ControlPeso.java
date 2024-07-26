public class ControlPeso extends ControlCalidad{
    @Override
    public void verificar(Articulo articulo) {
        if (articulo.getPeso() >= 1200 && articulo.getPeso() <= 1300) {
                siguienteControl.verificar(articulo);
        } else {
            System.out.println("El peso " + articulo.getPeso() + " no es válido.");
        }
    }
}
