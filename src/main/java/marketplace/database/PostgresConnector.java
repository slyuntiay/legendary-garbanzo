package marketplace.database;

import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

}
