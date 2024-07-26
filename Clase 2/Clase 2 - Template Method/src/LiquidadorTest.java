import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorTest {

    /*
    CASO 1: Debería emitir un documento en papel cuando es un empleado efectivo.
    ● Dado: Un empleado efectivo, Martín Martini, con un sueldo básico de 400, un
    valor fijo de descuentos de 40 y un total de 60 en premios.
    ● Cuando: Intento calcular la liquidación.
    ● Entonces: Obtengo el mensaje “La liquidación generada es un documento
    impreso. Saldo a liquidar: 420”
     */
    @Test
    public void CasoUno() {
        //arrange
        Empleado empleado = new EmpleadoEfectivo("Martín",
                "Martini",
                "123",
                400d,
                40d,
                60d);

        Liquidador liquidador = new LiquidadorEfectivo();

        String respuestaEsperada = "La liquidación generada es un documento" +
                " impreso. Saldo a liquidar: 420.0";

        //act
        String calcular = liquidador.liquidarSueldo(empleado);

        //assert
        assertEquals(respuestaEsperada, calcular);
    }

    @Test
    public void CasaDos(){
        //: Debería emitir un documento digital cuando es un empleado contratado.
        //● Dado: Una empleada contratada, Pompilia Pompini, con 120 horas trabajadas y
        //una tarifa de 7 por hora.
        //● Cuando: Intento calcular la liquidación.
        //● Entonces: Obtengo el mensaje “La liquidación generada es un documento
        //digital. Saldo a liquidar: 840”

        Empleado empleado = new EmpleadoContratado("Martín", "Martini",
                "123", 7d, 120d);
        Liquidador liquidador = new LiquidadorContratado();

        String respuestaEsperada = "La liquidación generada es un documento" + " digital. Saldo a liquidar: 840.0";

        String calcular = liquidador.liquidarSueldo(empleado);

        assertEquals(respuestaEsperada, calcular);

    }

    @Test
    public void CasaTres(){
        //El liquidador debería arrojar un mensaje de error cuando no es posible
        //calcular la liquidación.
        //Dados: Un liquidador de empleado efectivo y una empleada contratada,
        //Pompilia Pompini.
        //● Cuando: Intento calcular la liquidación.
        //● Entonces: Obtengo el mensaje “La liquidación no pudo ser calculada”.

        Empleado empleado = new EmpleadoContratado("Martín", "Martini",
                "123", -1d, 120d);
        Liquidador liquidador = new LiquidadorContratado();
        String respuestaEsperada = "La liquidación no pudo ser calculada";
        String calcular = liquidador.liquidarSueldo(empleado);
        assertEquals(respuestaEsperada, calcular);



        Empleado empleado2 = new EmpleadoEfectivo("Martín", "Martini",
                "123", -400d, -40d,60d);
        Liquidador liquidador2 = new LiquidadorEfectivo();
        String respuestaEsperada2 = "La liquidación no pudo ser calculada";
        String calcular2 = liquidador2.liquidarSueldo(empleado2);
        assertEquals(respuestaEsperada2, calcular2);
    }
}

