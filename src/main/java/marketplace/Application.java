package marketplace;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "marketplace.controller",
        "marketplace.service",
        "marketplace.repository"})
public class Application {
}