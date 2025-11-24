package marketplace.repository;

import lombok.RequiredArgsConstructor;

import java.sql.*;

@RequiredArgsConstructor
public class PostgresConnector {
    private final String url;
    private final String user;
    private final String password;

    public Boolean execute(String sql) {
        Boolean result = null;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            result = statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public void executeWithParam(String sql, String... params) {

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createProduct(String sql, String name, int price, int quantity) {

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, price);
            statement.setInt(3, quantity);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteProduct(String sql, String name, int price, int quantity) {}


}
