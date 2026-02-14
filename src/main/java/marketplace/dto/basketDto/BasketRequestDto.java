package marketplace.dto.basketDto;

import lombok.Data;

@Data
public class BasketRequestDto {
    private Long customerId;
    private Long productId;
    private Integer quantity;
}
