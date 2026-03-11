package marketplace.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class RabbitReceiver {

    @Bean
    public Consumer<String> receiveOrder() {
        return message -> {
            log.info("Получено сообщение: {}", message);
        };
    }
}
