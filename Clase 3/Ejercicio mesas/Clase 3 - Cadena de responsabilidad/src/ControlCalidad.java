public abstract class ControlCalidad {
    protected ControlCalidad siguienteControl;

    public ControlCalidad getSiguienteControl() {
        return siguienteControl;
    }

    public void setSiguienteControl(ControlCalidad siguienteControl) {
        this.siguienteControl = siguienteControl;
    }

    public abstract void verificar(Articulo articulo);
}
