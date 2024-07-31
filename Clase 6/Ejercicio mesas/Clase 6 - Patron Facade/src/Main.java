public class Main {
    public static void main(String[] args) {
        IBusquedaTurismo busquedaTurismo = new BusquedaTurismo();
        String ciudad = "Buenos Aires";
        String fechaDesde = "2024-08-01";
        String fechaHasta = "2024-08-15";

        busquedaTurismo.buscar(ciudad, fechaDesde, fechaHasta);
    }

}
