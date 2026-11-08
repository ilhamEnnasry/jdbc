import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    //Database Configuration
    private final String url = "jdbc:mysql://localhost:3306/javamysql";
    private final String user = "root";
    private final String password = "Root";

    // Store the single instance of DatabaseConnection
    private static DatabaseConnection instance;

    // Store the database connection
    private Connection connection;

    // Private constructor prevents creating objects from outside
    private DatabaseConnection(){}

    // Return the single instance of DatabaseConnection
    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }


    // Establish the database connection
    public Connection getConnection() throws SQLException {
        if(connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
