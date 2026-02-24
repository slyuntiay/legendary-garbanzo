package marketplace.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import marketplace.dto.contractor.ProductListUpdate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MarketplaceProductService {

    @RabbitListener(queues = "stock-updates")
    public void handleStockUpdate(ProductListUpdate update) {
        log.info("Получено обновление остатков: orderId={}, items={}",
                update.getOrderId(), update.getProductList());

        log.info("Остатки обновлены для заказа {}", update.getOrderId());
    }
}