package marketplace.service.rabbitReceiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitReceiver {

    @RabbitListener(queues = "${queue.name}")
    public void receive(String message,
                        @Header(AmqpHeaders.CONSUMER_QUEUE) String queueName) {
        log.info("{} received from {}", message, queueName);
    }
}
