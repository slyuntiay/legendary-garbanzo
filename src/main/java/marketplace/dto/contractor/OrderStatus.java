package marketplace.dto.contractor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderStatus {
    private Long orderId;
    private String status;
}
