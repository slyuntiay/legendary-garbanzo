package marketplace.database;

import lombok.Getter;

import java.sql.DriverManager;
import java.sql.Statement;

public class Connection {
    private static java.sql.Connection connection = null;
    @Getter
    private static Statement statement = null;

    public static void createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ourMarketplace", "LAnat", "3815");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
