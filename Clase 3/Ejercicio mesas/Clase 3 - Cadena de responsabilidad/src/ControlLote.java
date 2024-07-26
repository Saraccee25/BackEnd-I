public class ControlLote extends ControlCalidad {

    @Override
    public void verificar(Articulo articulo) {
        if(articulo.getLote() >= 1000 && articulo.getLote()
                <= 2000){
            siguienteControl.verificar(articulo);
        }
        else{
            System.out.println("El lote " + articulo.getLote() + " no es válido.");
        }
    }
}
