package marketplace.client;

import marketplace.dto.contractor.ContractorResponse;
import marketplace.dto.contractor.order.CreateOrderRequest;
import marketplace.dto.contractor.order.OrderStatus;
import marketplace.dto.contractor.product.ProductSetUpdate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "contractor",
        url = "${feign.client.config.contractor.url:http://localhost:8081}"
)
public interface ContractorClient {

    @PostMapping("order/save")
    ContractorResponse createOrder(@RequestBody CreateOrderRequest request);

    @GetMapping("contractor/find/{id}")
    OrderStatus findOrder(@PathVariable("id") Long id);

    @PostMapping("contractor/merge")
    String mergeStock(@RequestBody ProductSetUpdate update);
}
