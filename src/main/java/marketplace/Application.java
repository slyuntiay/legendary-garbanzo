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
    private String url;
    private String user;
    private String password;

   public void setConnectionUser(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }
    @Bean
    public Params getConnetionParams(){
        return new Params();
    }

    @Bean
    @Scope("prototype")
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}