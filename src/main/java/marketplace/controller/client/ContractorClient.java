package marketplace.controller.client;

import marketplace.dto.contractor.orderRequestDto.OrderRequest;
import marketplace.dto.contractor.orderStatus.OrderStatus;
import marketplace.dto.contractor.productListUpdate.ProductListUpdate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "contractor-service",
        url = "${feign.client.config.contractor.url:http://localhost:8081}"
)
@RequestMapping(name = "contractor")
public interface ContractorClient {

    // 1. Отправка заказа поставщику
    @PostMapping("/send")
    O send(@RequestBody OrderRequest request);

    // 2. Поиск статуса заказа
    @GetMapping("/find/{id}")
    OrderStatus find(@PathVariable("id") String orderId);

    // 3. Обновление остатков (merge)
    @PostMapping("/merge")
    String merge(@RequestBody ProductListUpdate update);
}
