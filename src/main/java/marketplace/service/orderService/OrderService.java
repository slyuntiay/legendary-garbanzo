package marketplace.service.orderService;

import lombok.RequiredArgsConstructor;
import marketplace.client.ContractorClient;
import marketplace.dto.contractor.ContractorResponse;
import marketplace.dto.contractor.OrderRequest;
import marketplace.dto.contractor.OrderStatus;
import marketplace.dto.contractor.ProductListUpdate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ContractorClient contractorClient;
    private final RabbitTemplate rabbitTemplate;

    public String createOrder(OrderRequest request) {

        ContractorResponse response = contractorClient.sendOrder(request);

        ProductListUpdate update = new ProductListUpdate(request.getId(), request.getProductList());
        rabbitTemplate.convertAndSend("stock-requests", update);

        return response.getMessage();
    }

    public OrderStatus checkOrderStatus(Long id) {
        return contractorClient.findOrder(id);
    }
}
