package marketplace.controller.orderController;

import lombok.RequiredArgsConstructor;
import marketplace.dto.contractor.order.CreateOrderRequest;
import marketplace.dto.contractor.order.OrderStatus;
import marketplace.service.orderService.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRequest request) {
        String result = orderService.createOrder(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<OrderStatus> checkOrderStatus(@PathVariable Long id) {
        OrderStatus status = orderService.checkOrderStatus(id);
        return ResponseEntity.ok(status);
    }
}
