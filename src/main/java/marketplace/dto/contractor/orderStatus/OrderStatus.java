package marketplace.dto.contractor.orderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderStatus {
    private Long orderId;
    private String status;
}
