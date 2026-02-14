package marketplace.dto.basketDto;

import lombok.Data;

@Data
public class BasketRequestDto {
    private Long clientId;
    private Long productId;
    private Integer quantity;
}
