public class ServicioDescarga implements IServicioDescarga{
    @Override
    public void descargar(String cancion, Usuario usuario) {
        System.out.println("Descargando la canción: " + cancion + " para el usuario: " + usuario.getId());
    }
}
