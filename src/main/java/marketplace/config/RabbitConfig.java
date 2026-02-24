package marketplace.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue stockUpdateQueue() {
        return new Queue("stock-updates", true);
    }

    @Bean
    public TopicExchange stockExchange() {
        return new TopicExchange("stock-exchange");
    }

    @Bean
    public Binding binding(Queue stockUpdateQueue, TopicExchange stockExchange) {
        return BindingBuilder
                .bind(stockUpdateQueue)
                .to(stockExchange)
                .with("stock.*");
    }
}