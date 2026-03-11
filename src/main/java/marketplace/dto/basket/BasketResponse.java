package marketplace.dto.basket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketResponse {
    private Long id;
    private Long customerId;
    private Long productId;
    private Integer quantity;
}
