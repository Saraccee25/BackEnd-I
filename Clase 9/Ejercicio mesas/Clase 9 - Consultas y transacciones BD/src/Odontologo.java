import java.sql.*;

public class Odontologo {
    // Consultas SQL
    private static final String DROP_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS (" +
            "MATRICULA VARCHAR(100) PRIMARY KEY, " +
            "NOMBRE VARCHAR(100) NOT NULL, " +
            "APELLIDO VARCHAR(100) NOT NULL)";
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES (?,?,?)";
    private static final String SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
    private static final String SQL_UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA=? WHERE MATRICULA=?";

    public static void main(String[] args) {
        // Conexión a la BD
        Connection connection = null;

        try {
            // Conectarse a la BD
            connection = getConnection();

            // Crear la tabla
            Statement statement = connection.createStatement();
            statement.execute(DROP_CREATE);

            // Insertar valores
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, "100");
            preparedStatement.setString(2, "Sara");
            preparedStatement.setString(3, "Castañeda");
            preparedStatement.execute();

            // consulto
            ResultSet rs = statement.executeQuery(SELECT_ALL);
            System.out.println("Antes de la actualización:");
            while (rs.next()) {
                System.out.println("El odontólogo: " +
                        rs.getString("NOMBRE") + " con apellido " +
                        rs.getString("APELLIDO") + " tiene como matrícula " +
                        rs.getString("MATRICULA"));
            }

            // actualizar la matrícula
            PreparedStatement updateStatement = connection.prepareStatement(SQL_UPDATE);
            updateStatement.setString(1, "200");
            updateStatement.setString(2, "100");
            updateStatement.execute();

            
            rs = statement.executeQuery(SELECT_ALL);
            System.out.println("Después de la actualización:");
            while (rs.next()) {
                System.out.println("El odontólogo: " +
                        rs.getString("NOMBRE") + " con apellido " +
                        rs.getString("APELLIDO") + " tiene como matrícula " +
                        rs.getString("MATRICULA"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Método para conectarse a la BD
    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./odontologosDB", "sa", "sa");
    }
}
