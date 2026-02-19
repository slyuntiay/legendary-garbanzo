package marketplace.controller.orderController;

import lombok.RequiredArgsConstructor;
import marketplace.dto.contractor.orderRequestDto.OrderRequest;
import marketplace.dto.contractor.orderStatus.OrderStatus;
import marketplace.service.orderService.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;  // твой сервис с Feign

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest request) {
        String result = orderService.createOrder(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<OrderStatus> getOrderStatus(@PathVariable Long id) {
        OrderStatus status = orderService.checkOrderStatus(id);
        return ResponseEntity.ok(status);
    }
}
