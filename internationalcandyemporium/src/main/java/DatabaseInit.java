import java.sql.Connection;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;

public class DatabaseInit {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/InternationalCandyEmporium";
        String user = "root";  
        String password = "password";  

        Connection connection = null;
try {
    connection = DriverManager.getConnection(url, user, password);  // Note the change here

    // Create and use the database
    Statement initStatement = connection.createStatement();
    initStatement.execute("CREATE DATABASE IF NOT EXISTS InternationalCandyEmporium");
    initStatement.execute("USE InternationalCandyEmporium");
    

    String sqlCommands = new String(Files.readAllBytes(Paths.get("candystore/database_schema.sql")));
    String[] sqlArray = sqlCommands.split(";");

    Statement statement = connection.createStatement();
    for (String sqlCmd : sqlArray) {
        if (!sqlCmd.trim().isEmpty()) {
            statement.execute(sqlCmd);
        }
    }

    System.out.println("Database schema successfully imported.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to import database schema.");
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
}
