package marketplace.service.orderService;

import lombok.RequiredArgsConstructor;
import marketplace.controller.client.ContractorClient;
import marketplace.dto.contractor.orderRequestDto.OrderRequest;
import marketplace.dto.productDto.ProductRequestDto;
import marketplace.dto.productDto.ProductResponseDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ContractorClient contractorClient;

    public OrderRequest send(OrderRequest orderRequest) {
        return contractorClient.send(orderRequest);
    }
}
