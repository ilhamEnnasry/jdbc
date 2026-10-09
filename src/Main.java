import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javamysql";
        String user = "root";
        String password = "Root@123";

        try {
            // Create connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database successfully");

            // Create Statement
            Statement statement = connection.createStatement();
            System.out.println("Statement created successfully");

            // SQL query
            //String createsql = "CREATE TABLE CUSTOMER (" +
              //      "id INT, " +
                //    "name VARCHAR(100)," +
                  //  "age INT)";

            // Send SQL to MySQL
            //statement.executeUpdate(createsql);
            System.out.println("Table created successfully");

            // SQL query
            //String insertsql = "INSERT INTO CUSTOMER (id, name, age)" + " VALUES (1, 'Customer1', 30 )," + " (2, 'Customer2', 20)," + " (3, 'Customer3', 28)";
            // Send SQL to MySQL
            //statement.executeUpdate(insertsql);

            // SQL query
            String selectSQL = "SELECT * FROM CUSTOMER";
            // Send SQL to MySQL
            ResultSet resultSet = statement.executeQuery(selectSQL);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");

                System.out.println("ID:" + id + " NAME:" + name + " AGE:" + age);
            }

            // Close resources
            statement.close();
            connection.close();

        } catch(SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}