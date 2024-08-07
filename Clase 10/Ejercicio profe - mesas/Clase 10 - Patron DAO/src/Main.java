import dao.BD;
import modelo.Medicamento;
import servicio.MedicamentoService;

public class Main {
    public static void main(String[] args) {
        //crear un medicamento y lo vamos a persistir

        MedicamentoService medicamentoService = new MedicamentoService();

        //con este método creamos las tablas
        BD.createTable();

        //creamos un medicamento
        Medicamento paracetamol = new Medicamento("Paracetamol", "Bayer", 11, 2500d, 11);
        medicamentoService.guardar(paracetamol);
        
        // Buscar el medicamento por ID
        Medicamento medicamentoBuscado = medicamentoService.buscarPorId(paracetamol.getId());
        if (medicamentoBuscado != null) {
            System.out.println("Medicamento encontrado: " + medicamentoBuscado.getNombre());
        } else {
            System.out.println("Medicamento no encontrado.");
        }

    }
}
