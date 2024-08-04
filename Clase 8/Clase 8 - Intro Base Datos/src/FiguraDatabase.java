import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FiguraDatabase {
    public static void main(String[] args) {
            Connection connection = null;
            Statement statement = null;

            try {
                // Cargar el driver de H2
                Class.forName("org.h2.Driver");

                // Crear la conexión a la base de datos en memoria
                connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

                // Crear el statement
                statement = connection.createStatement();

                // Crear la tabla
                String createTableSQL = "CREATE TABLE IF NOT EXISTS Figura (" +
                        "ID INT PRIMARY KEY AUTO_INCREMENT, " +
                        "Tipo VARCHAR(255), " +
                        "Color VARCHAR(255))";
                statement.execute(createTableSQL);

                // Insertar las figuras
                String insertFiguresSQL = "INSERT INTO Figura (Tipo, Color) VALUES " +
                        "('circulo', 'rojo'), " +
                        "('circulo', 'azul'), " +
                        "('cuadrado', 'verde'), " +
                        "('cuadrado', 'rojo'), " +
                        "('cuadrado', 'amarillo')";
                statement.execute(insertFiguresSQL);

                // Crear una query para ver los círculos color rojo
                String selectRedCirclesSQL = "SELECT * FROM Figura WHERE Tipo = 'circulo' AND Color = 'rojo'";
                ResultSet rs = statement.executeQuery(selectRedCirclesSQL);

                // Mostrar todas las figuras en pantalla
                System.out.println("Círculos color rojo:");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ID") +
                            ", Tipo: " + rs.getString("Tipo") +
                            ", Color: " + rs.getString("Color"));
                }

                // Mostrar todas las figuras
                String selectAllFiguresSQL = "SELECT * FROM Figura";
                rs = statement.executeQuery(selectAllFiguresSQL);

                System.out.println("\nTodas las figuras:");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("ID") +
                            ", Tipo: " + rs.getString("Tipo") +
                            ", Color: " + rs.getString("Color"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) statement.close();
                    if (connection != null) connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

