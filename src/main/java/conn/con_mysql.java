package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class con_mysql {

    private static final String URL = "jdbc:mysql://localhost:3308/instituto?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "pulpillox7";

    // Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        try {
            // Cargar driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("No se pudo cargar el driver de MySQL: " + e.getMessage());
        }

        // Retorna la conexión
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Método para cerrar la conexión
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
