package marketplace.config;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Component
public class DataSource {
    public static String url = "jdbc:postgresql://localhost:5432/ourMarketplace";
    public static String name = "LAnat";
    public static String password = "3815";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }
}
