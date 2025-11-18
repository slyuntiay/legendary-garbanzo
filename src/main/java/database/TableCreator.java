package database;

import java.sql.*;

public class TableCreator {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/ourMarketplace", "LAnat", "3815");
            statement = connection.createStatement();

            String str = "CREATE TABLE users (" +
                    "user_id serial PRIMARY KEY," +
                    "name varchar(32) NOT NULL," +
                    "age smallint NOT NULL)";
            statement.executeUpdate(str);

            statement.close();
            connection.close();

            System.out.println("Table created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
