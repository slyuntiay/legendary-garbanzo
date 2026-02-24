package marketplace.client;

import marketplace.dto.contractor.ContractorResponse;
import marketplace.dto.contractor.OrderRequest;
import marketplace.dto.contractor.OrderStatus;
import marketplace.dto.contractor.ProductListUpdate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "contractor",
        url = "${feign.client.config.contractor.url:http://localhost:8081}"
)
public interface ContractorClient {

    @PostMapping("/send")
    ContractorResponse sendOrder(@RequestBody OrderRequest request);

    @GetMapping("/find/{id}")
    OrderStatus findOrder(@PathVariable("id") Long id);

    @PostMapping("/merge")
    String mergeStock(@RequestBody ProductListUpdate update);
}
