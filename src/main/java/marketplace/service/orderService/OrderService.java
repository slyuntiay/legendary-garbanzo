package marketplace.service.orderService;

import lombok.RequiredArgsConstructor;
import marketplace.client.ContractorClient;
import marketplace.dto.contractor.ContractorResponse;
import marketplace.dto.contractor.order.CreateOrderRequest;
import marketplace.dto.contractor.order.OrderStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ContractorClient contractorClient;

    public String createOrder(CreateOrderRequest request) {
        ContractorResponse response = contractorClient.createOrder(request);
        return response.getMessage();
    }

    public OrderStatus checkOrderStatus(Long id) {
        return contractorClient.findOrder(id);
    }
}
