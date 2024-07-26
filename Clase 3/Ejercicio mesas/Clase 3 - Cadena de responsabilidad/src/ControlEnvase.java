import javax.sound.sampled.Control;

public class ControlEnvase extends ControlCalidad {
    @Override
    public void verificar(Articulo articulo) {
        if (articulo.getEnvasado().equals("sano") || articulo.getEnvasado().equals("casi sano")) {
                siguienteControl.verificar(articulo);
        } else {
            System.out.println("El envase " + articulo.getEnvasado() + " no es válido.");
        }
    }
}
