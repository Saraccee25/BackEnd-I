public class EmpleadoContratado extends Empleado {
    private Double valorPorHora;
    private Double cantidadDeHora;

    public EmpleadoContratado(String nombre, String apellido, String numeroDeCuenta, Double valorPorHora, Double cantidadDeHora) {
        super(nombre, apellido, numeroDeCuenta);
        this.valorPorHora = valorPorHora;
        this.cantidadDeHora = cantidadDeHora;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Double getCantidadDeHora() {
        return cantidadDeHora;
    }

    public void setCantidadDeHora(Double cantidadDeHora) {
        this.cantidadDeHora = cantidadDeHora;
    }
}
