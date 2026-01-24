package marketplace.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.datasource")
@Getter
@Setter
public class DataSourceProperties {
    private String url;
    private String username;
    private String password;
}