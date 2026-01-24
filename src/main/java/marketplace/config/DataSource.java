package marketplace.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@Component
public class DataSource {
    public static String url;
    public static String name;
    public static String password;

    @Autowired
    public DataSource(DataSourceProperties properties) {
        this.url = properties.getUrl();
        this.name = properties.getUsername();
        this.password = properties.getPassword();
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }
}
