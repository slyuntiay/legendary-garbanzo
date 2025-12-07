package marketplace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Scanner;

@Configuration
@ComponentScan({
        "marketplace.controller",
        "marketplace.service",
        "marketplace.repository"})
public class Application {
    @Bean
    @Scope("prototype")
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public String[] userData(String[] args) {
        String user;
        String url;
        String password;

        return args;
    }
}