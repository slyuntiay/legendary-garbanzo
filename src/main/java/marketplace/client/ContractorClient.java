package marketplace.client;

import marketplace.dto.contractor.contractorDto.ContractorResponse;
import marketplace.dto.contractor.orderRequestDto.OrderRequest;
import marketplace.dto.contractor.orderStatus.OrderStatus;
import marketplace.dto.contractor.productListUpdate.ProductListUpdate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "contractor",
        url = "${feign.client.config.contractor.url:http://localhost:8081}"
)
@RequestMapping(name = "contractor")
public interface ContractorClient {

    @PostMapping("/send")
    ContractorResponse sendOrder(@RequestBody OrderRequest request);

    @GetMapping("/find/{id}")
    OrderStatus findOrder(@PathVariable("id") Long id);

    @PostMapping("/merge")
    String mergeStock(@RequestBody ProductListUpdate update);
}
