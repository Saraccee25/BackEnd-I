import javax.naming.ldap.Control;

public class CompruebaCalidad {
    private ControlCalidad primerControl;

    public CompruebaCalidad() {
        // Configurar la cadena de responsabilidad
        ControlCalidad controlLote = new ControlLote();
        ControlCalidad controlPeso = new ControlPeso();
        ControlCalidad controlEnvase = new ControlEnvase();

        controlLote.setSiguienteControl(controlPeso);
        controlPeso.setSiguienteControl(controlEnvase);

        primerControl = controlLote;
    }

    public void verificarCalidad(Articulo articulo) {
        primerControl.verificar(articulo);
    }
}
