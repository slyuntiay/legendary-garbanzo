package marketplace.database;

import java.sql.DriverManager;
import java.sql.Statement;

public class Connection {
    public static void createConnection() {
        java.sql.Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ourMarketplace", "LAnat", "3815");
            statement = connection.createStatement();

            statement.close();
            connection.close();

            System.out.println("Table created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
