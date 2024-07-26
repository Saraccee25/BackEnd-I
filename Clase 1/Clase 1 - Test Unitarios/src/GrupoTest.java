import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrupoTest {
    /* Dadas 5 personas (Juan, Pedro, Ana, Luz y Julián) y una colección vacía de
    objetos tipo Persona, cuando se intentan agregar estas a la colección, el
    tamaño de la colección debería ser 2 */

    @Test
    public void casoUno() {
        //arrange -> dado lo que necesito para hacer la prueba
        Persona juan = new Persona("Juan", 20);
        Persona pedro = new Persona("Pedro", 20);
        Persona ana = new Persona("Ana", 20);
        Persona luz = new Persona("Luz", 20);
        Persona julian = new Persona("Julián", 20);

        Grupo grupo1 = new Grupo();

        //act -> ocurre el proceso, la acción
        grupo1.agregarPersona(juan);
        grupo1.agregarPersona(pedro);
        grupo1.agregarPersona(ana);
        grupo1.agregarPersona(luz);
        grupo1.agregarPersona(julian);

        //assert -> comparo con lo que espero
        assertTrue(grupo1.getPersonas().size() == 2);

    }
    @Test
    public void casoDos(){
        //Dadas 5 personas (18 años, 17 años, 22 años, 14 años y 32 años), el tamaño de
        //la colección debería ser 3

        Persona adriana = new Persona("Adriana", 18);
        Persona camilo = new Persona("Camilo", 17);
        Persona mariana = new Persona("Mariana", 22);
        Persona erica = new Persona("Erica", 14);
        Persona julian = new Persona("Julian", 32);

        Grupo grupo2 = new Grupo(); //Se inicializa grupo /intancia

        grupo2.agregarPersona(adriana);
        grupo2.agregarPersona(camilo);
        grupo2.agregarPersona(mariana);
        grupo2.agregarPersona(erica);
        grupo2.agregarPersona(julian);

        assertTrue(grupo2.getPersonas().size()==3);

    }
    @Test
    public void casoTres(){
        //Dado 5 personas (N1c0las, Tomas, 3steban, Carlos\sV, Francisco\sII), el tamaño
        //de la colección debería ser 1.

        Persona nicolas = new Persona("N1c0las", 18);
        Persona tomas = new Persona("Tomas", 18);
        Persona esteban = new Persona("3steban", 22);
        Persona carlos = new Persona("Carlos\sV", 18);
        Persona francisco = new Persona("Francisco\sII", 32);

        Grupo grupo3 = new Grupo(); //Se inicializa grupo /intancia

        grupo3.agregarPersona(nicolas);
        grupo3.agregarPersona(tomas);
        grupo3.agregarPersona(esteban);
        grupo3.agregarPersona(carlos);
        grupo3.agregarPersona(francisco);

        assertTrue(grupo3.getPersonas().size()==1);
    }

}