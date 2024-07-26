public class ProxyServicioDescarga implements IServicioDescarga{
    private ServicioDescarga servicioDescarga;

    public ProxyServicioDescarga() {
        this.servicioDescarga = new ServicioDescarga();
    }
    @Override
    public void descargar(String cancion, Usuario usuario) {
        if (usuario.getTipoUsuario().equalsIgnoreCase("Premium")) {
            servicioDescarga.descargar(cancion, usuario);
        } else {
            System.out.println("Acceso denegado. Solo los usuarios premium pueden descargar canciones.");
        }
    }
}
