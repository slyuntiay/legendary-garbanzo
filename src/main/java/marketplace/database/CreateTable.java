package marketplace.database;

import java.sql.*;

public class CreateTable {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ourMarketplace", "LAnat", "3815");
            statement = connection.createStatement();

            String str = "CREATE TABLE clients (" +
                    "client_id serial PRIMARY KEY," +
                    "surname varchar(32) NOT NULL," +
                    "name varchar(32) NOT NULL)";
            statement.executeUpdate(str);

            statement.close();
            connection.close();

            System.out.println("Table created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
