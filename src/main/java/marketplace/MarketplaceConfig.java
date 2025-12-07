package marketplace;

import marketplace.params.ConnectionParams;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Scanner;

@Configuration
@ComponentScan({
        "marketplace.service",
        "marketplace.repository"})
public class MarketplaceConfig {
    private String url;
    private String user;
    private String password;

    public void setConnectionParams(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Bean
    public ConnectionParams getConnectionParams() {
        return new ConnectionParams(url, user, password);
    }

    @Bean
    @Scope(value = "prototype")
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

}